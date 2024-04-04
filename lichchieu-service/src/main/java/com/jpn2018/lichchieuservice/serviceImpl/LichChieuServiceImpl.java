package com.jpn2018.lichchieuservice.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpn2018.lichchieuservice.entity.LichChieu;
import com.jpn2018.lichchieuservice.repository.LichChieuRepository;
import com.jpn2018.lichchieuservice.service.LichChieuService;

import java.util.List;
import java.util.Optional;

@Service
public class LichChieuServiceImpl implements LichChieuService {

    @Autowired
    private LichChieuRepository lichChieuRepository;

    @Override
    public LichChieu saveLichChieu(LichChieu lichChieu) {
        return lichChieuRepository.save(lichChieu);
    }

    @Override
    public List<LichChieu> getAllLichChieus() {
        return lichChieuRepository.findAll();
    }

    @Override
    public LichChieu getLichChieuById(Long id) {
        Optional<LichChieu> lichChieu = lichChieuRepository.findById(id);
        if (lichChieu.isPresent()) {
            return lichChieu.get();
        } else {
            // Handle not found exception or return null/throw exception
            // For example:
            // throw new NotFoundException("LichChieu not found with ID: " + id);
            return null;
        }
    }

    @Override
    public void deleteLichChieuById(Long id) {
        lichChieuRepository.deleteById(id);
    }

    @Override
    public LichChieu updateLichChieu(Long id, LichChieu lichChieu) {
        Optional<LichChieu> existingLichChieu = lichChieuRepository.findById(id);
        if (existingLichChieu.isPresent()) {
            
            // Set other attributes accordingly

            return lichChieuRepository.save(lichChieu);
        } else {
            // Handle not found exception or return null/throw exception
            // For example:
            // throw new NotFoundException("LichChieu not found with ID: " + id);
            return null;
        }
    }

    @Override
    public List<LichChieu> findLichChieuByPhimId(Long phimId) {
        
        System.out.println(lichChieuRepository.findByPhimId(phimId));
        return lichChieuRepository.findByPhimId(phimId);
    }
}
