package com.jpn2018.lichchieuservice.serviceImpl;

import com.jpn2018.lichchieuservice.client.*;
import com.jpn2018.lichchieuservice.dto.*;
import com.jpn2018.lichchieuservice.entity.LichChieu;
import com.jpn2018.lichchieuservice.entity.LichChieuFullResponse;
import com.jpn2018.lichchieuservice.repository.LichChieuRepository;
import com.jpn2018.lichchieuservice.service.LichChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LichChieuServiceImpl implements LichChieuService {

    @Autowired
    private LichChieuRepository lichChieuRepository;
    @Autowired
    private GheClient gheClient;
    @Autowired
    private PhimClient phimClient;
    @Autowired
    private PhongChieuClient phongChieuClient;
    @Autowired
    private KhungGioClient khungGioClient;
    @Autowired
    private RapClient rapClient;

    @Autowired
    private ProgressClient progressClient;

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
    public LichChieuFullResponse getLichChieuFullResponseById(Long id) {
        LichChieu lichChieu = lichChieuRepository.findById(id).get();
        Phim phim = phimClient.getPhimById(lichChieu.getPhimId());
        PhongChieu phongChieu = phongChieuClient.getPhongChieuById(lichChieu.getPhongChieuId());
        Rap rap = rapClient.getRapById(phongChieu.getRapId());
        KhungGio khungGio = khungGioClient.getKhungGioById(lichChieu.getKhungGioId());
        PhongChieuFullResponse phongChieuFullResponse = PhongChieuFullResponse.builder()
                .id(phongChieu.getId())
                .name(phongChieu.getName())
                .capacity(phongChieu.getCapacity())
                .description(phongChieu.getDescription())
                .rap(rap)
                .build();
        LichChieuFullResponse lichChieuFullResponse = LichChieuFullResponse.builder()
                .id(lichChieu.getId())
                .date(lichChieu.getDate())
                .price(lichChieu.getPrice())
                .phim(phim)
                .phongChieu(phongChieuFullResponse)
                .khungGio(khungGio)
                .build();

        return lichChieuFullResponse;
    }

    @Override
    public List<LichChieuFullResponse> findLichChieuByPhimId(Long phimId) {
//        progressClient.sendProgress("get lich chieu", 25);

        List<LichChieu> lichChieus = lichChieuRepository.findByPhimId(phimId);
        List<LichChieuFullResponse> responses = new ArrayList<>();

        for (LichChieu lichChieu : lichChieus) {
            Phim phim = phimClient.getPhimById(phimId);
            PhongChieu phongChieu = phongChieuClient.getPhongChieuById(lichChieu.getPhongChieuId());
            Rap rap = rapClient.getRapById(phongChieu.getRapId());
            PhongChieuFullResponse phongChieuFullResponse = PhongChieuFullResponse.builder()
                    .id(phongChieu.getId())
                    .name(phongChieu.getName())
                    .capacity(phongChieu.getCapacity())
                    .description(phongChieu.getDescription())
                    .rap(rap)
                    .build();
            KhungGio khungGio = khungGioClient.getKhungGioById(lichChieu.getKhungGioId());

            LichChieuFullResponse response = LichChieuFullResponse.builder()
                    .id(lichChieu.getId())
                    .price(lichChieu.getPrice())
                    .date(lichChieu.getDate())
                    .phim(phim)
                    .phongChieu(phongChieuFullResponse)
                    .khungGio(khungGio)
                    .build();

            responses.add(response);
        }

        return responses;
    }

    public LichChieuDto toDto(LichChieu lichChieu) {
        PhongChieu phongChieu = phongChieuClient.getPhongChieuById(lichChieu.getPhongChieuId());
        Phim phim = phimClient.getPhimById(lichChieu.getPhimId());
//    	Ghe ghe = gheClient.getGheById(lichChieu.getKhungGioId());
        KhungGio khungGio = khungGioClient.getKhungGioById(lichChieu.getKhungGioId());
        return LichChieuDto.builder().id(lichChieu.getId())
                .date(lichChieu.getDate())
                .price(lichChieu.getPrice())
                .tenPhong(phongChieu.getName())
                .tenPhim(phim.getName())
                .timeEnd(khungGio.getTimeEnd())
                .timeStart(khungGio.getTimeStart())
                .build();
    }

    @Override
    public List<LichChieuDto> getAllLichChieuDtos() {
        // TODO Auto-generated method stub
        return lichChieuRepository.findAll().stream().map((item) -> toDto(item)).toList();
    }

    @Override
    public LichChieuDto getLichChieuDtoById(Long id) {
        // TODO Auto-generated method stub
        Optional<LichChieu> lichChieu = lichChieuRepository.findById(id);
        if (lichChieu.isPresent()) {
            return toDto(lichChieu.get());
        } else {
            // Handle not found exception or return null/throw exception
            // For example:
            // throw new NotFoundException("LichChieu not found with ID: " + id);
            return null;
        }
    }
}
