package com.jpn2018.phongchieuservice.serviceImpl;

import com.jpn2018.phongchieuservice.entity.PhongChieu;
import com.jpn2018.phongchieuservice.repository.PhongChieuRepository;
import com.jpn2018.phongchieuservice.service.PhongChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongChieuServiceImpl implements PhongChieuService {

    @Autowired
    private PhongChieuRepository phongChieuRepository;

    @Override
    public PhongChieu savePhongChieu(PhongChieu phongChieu) {
        return phongChieuRepository.save(phongChieu);
    }

    @Override
    public List<PhongChieu> getAllPhongChieus() {
        return phongChieuRepository.findAll();
    }

    @Override
    public List<PhongChieu> getAllPhongchieusByRap(Long rapId) {
        return phongChieuRepository.findAllByRapId(rapId);
    }

    @Override
    public PhongChieu getPhongChieuById(Long id) {
        Optional<PhongChieu> phongChieu = phongChieuRepository.findById(id);
        if (phongChieu.isPresent()) {
            return phongChieu.get();
        } else {
            return null;
        }
    }

    @Override
    public void deletePhongChieuById(Long id) {
        phongChieuRepository.deleteById(id);
    }

    @Override
    public PhongChieu updatePhongChieu(Long id, PhongChieu phongChieu) {
        Optional<PhongChieu> existingPhongChieu = phongChieuRepository.findById(id);
        if (existingPhongChieu.isPresent()) {
            PhongChieu updatedPhongChieu = existingPhongChieu.get();
            updatedPhongChieu.setName(phongChieu.getName());
            updatedPhongChieu.setCapacity(phongChieu.getCapacity());
            updatedPhongChieu.setDescription(phongChieu.getDescription());

            return phongChieuRepository.save(updatedPhongChieu);
        } else {
            return null;
        }
    }
}
