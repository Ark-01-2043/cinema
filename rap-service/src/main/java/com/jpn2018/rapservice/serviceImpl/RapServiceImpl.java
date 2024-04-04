package com.jpn2018.rapservice.serviceImpl;

import com.jpn2018.rapservice.client.PhongChieuClient;
import com.jpn2018.rapservice.entity.Rap;
import com.jpn2018.rapservice.entity.RapFullResponse;
import com.jpn2018.rapservice.repository.RapRepository;
import com.jpn2018.rapservice.service.RapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RapServiceImpl implements RapService {

    @Autowired
    RapRepository rapRepository;

    @Autowired
    PhongChieuClient phongChieuClient;

    @Override
    public Rap saveRap(Rap rap) {
        return rapRepository.save(rap);
    }

    @Override
    public List<Rap> getListRap() {
        return rapRepository.findAll();
    }

    @Override
    public RapFullResponse findRapsWithPhongchieus(Long rapId) {
        var rap = rapRepository.findById(rapId)
                .orElse(
                        Rap.builder()
                                .name("NOT_FOUND")
                                .address("NOT_FOUND")
                                .tel("NOT_FOUND")
                                .description("NOT_FOUND")
                                .build()
                );
        var phongchieus = phongChieuClient.findAllPhongchieusByRap(rapId);
        return RapFullResponse.builder()
                .name(rap.getName())
                .address(rap.getAddress())
                .tel(rap.getTel())
                .description(rap.getDescription())
                .phongChieus(phongchieus)
                .build();
    }

    @Override
    public Rap getRapById(Long rapId) {
        Optional<Rap> rap = rapRepository.findById(rapId);
        if (!rap.isPresent()) {
            // Throw an exception or handle the situation when rap is not found
            System.out.println("Rap not found");
            // throw new NotFoundException("Rap not found with ID: " + rapId);
        }
        return rap.get();
    }

    @Override
    public void deleteRapById(Long rapId) {
        rapRepository.deleteById(rapId);
    }

    @Override
    public Rap updateRap(Long rapId, Rap rap) {
        Rap oldRap = rapRepository.findById(rapId).get();
        oldRap.setName(rap.getName());
        oldRap.setAddress(rap.getAddress());
        oldRap.setTel(rap.getTel());
        oldRap.setDescription(rap.getDescription());
        // Set other attributes accordingly

        return rapRepository.save(oldRap);
    }
}
