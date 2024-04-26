package com.jpn2018.lichchieuservice.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpn2018.lichchieuservice.client.GheClient;
import com.jpn2018.lichchieuservice.client.KhungGioClient;
import com.jpn2018.lichchieuservice.client.PhimClient;
import com.jpn2018.lichchieuservice.client.PhongChieuClient;
import com.jpn2018.lichchieuservice.dto.Ghe;
import com.jpn2018.lichchieuservice.dto.KhungGio;
import com.jpn2018.lichchieuservice.dto.LichChieuDto;
import com.jpn2018.lichchieuservice.dto.Phim;
import com.jpn2018.lichchieuservice.dto.PhongChieu;
import com.jpn2018.lichchieuservice.entity.LichChieu;
import com.jpn2018.lichchieuservice.repository.LichChieuRepository;
import com.jpn2018.lichchieuservice.service.LichChieuService;

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
