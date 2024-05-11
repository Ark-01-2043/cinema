package com.jpn2018.veservice.serviceImpl;

import com.jpn2018.veservice.client.GheClient;
import com.jpn2018.veservice.client.LichChieuClient;
import com.jpn2018.veservice.dto.*;
import com.jpn2018.veservice.entity.Ve;
import com.jpn2018.veservice.repository.VeRepository;
import com.jpn2018.veservice.service.VeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VeServiceImpl implements VeService {

    @Autowired
    private VeRepository veRepository;
    @Autowired
    private GheClient gheClient;
    @Autowired
    private LichChieuClient lichChieuClient;


    @Override
    public Ve saveVe(Ve ve) {
        return veRepository.save(ve);
    }

    @Override
    public List<Ve> getAllVes() {
        return veRepository.findAll();
    }

    @Override
    public Ve getVeById(Long id) {
        Optional<Ve> ve = veRepository.findById(id);
        if (ve.isPresent()) {
            return ve.get();
        } else {
            // Handle not found exception or return null/throw exception
            // For example:
            // throw new NotFoundException("Ve not found with ID: " + id);
            return null;
        }
    }

    @Override
    public void deleteVeById(Long id) {
        veRepository.deleteById(id);
    }

    @Override
    public Ve updateVe(Long id, Ve ve) {
        Optional<Ve> existingVe = veRepository.findById(id);
        if (existingVe.isPresent()) {


            return veRepository.save(ve);
        } else {
            // Handle not found exception or return null/throw exception
            // For example:
            // throw new NotFoundException("Ve not found with ID: " + id);
            return null;
        }
    }

    @Override
    public List<VeFullResponse> findVeByLichChieu(Long lichChieuId) {
        List<Ve> ves = veRepository.findByLichChieuId(lichChieuId);
        List<VeFullResponse> responses = new ArrayList<>();

        for (Ve ve : ves) {
            Ghe ghe = gheClient.getGheById(ve.getGheId());
            LichChieuFullResponse lichChieuFullResponse = lichChieuClient.getLichChieuFullResponseById(lichChieuId);

            VeFullResponse response = VeFullResponse.builder()
                    .id(ve.getId())
                    .lichChieu(lichChieuFullResponse)
                    .ghe(ghe)
                    .booked(ve.getBooked())
                    .build();

            responses.add(response);
        }
        System.out.println(responses);

        return responses;
    }

    @Override
    public VeDto toDto(Ve ve) {
        // TODO Auto-generated method stub
        LichChieuDto lichChieuDto = lichChieuClient.getLichChieuDtoById(ve.getLichChieuId()).getBody();
        Ghe ghe = gheClient.getGheById(ve.getGheId());
        return VeDto.builder().id(ve.getId())
                .date(lichChieuDto.getDate())
                .numberChair(ghe.getNumberChair())
                .price(lichChieuDto.getPrice())
                .tenPhim(lichChieuDto.getTenPhim())
                .tenPhong(lichChieuDto.getTenPhong())
                .timeEnd(lichChieuDto.getTimeEnd())
                .timeStart(lichChieuDto.getTimeStart())
                .build();
    }

    @Override
    public List<VeDto> getAllVeDtos() {
        // TODO Auto-generated method stub
        return veRepository.findAll().stream().map((item) -> toDto(item)).toList();
    }

    @Override
    public VeDto getVeDtoById(Long id) {
        // TODO Auto-generated method stub
        Optional<Ve> ve = veRepository.findById(id);
        if (ve.isPresent()) {
            return toDto(ve.get());
        } else {
            // Handle not found exception or return null/throw exception
            // For example:
            // throw new NotFoundException("Ve not found with ID: " + id);
            return null;
        }
    }
}