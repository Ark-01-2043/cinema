package com.jpn2018.doidiemservice.serviceImpl;

import com.jpn2018.doidiemservice.client.DichVuClient;
import com.jpn2018.doidiemservice.client.ThanhVienClient;
import com.jpn2018.doidiemservice.entity.ChiTietDoi;
import com.jpn2018.doidiemservice.entity.DichVu;
import com.jpn2018.doidiemservice.entity.HoaDonDoi;
import com.jpn2018.doidiemservice.entity.ThanhVien;
import com.jpn2018.doidiemservice.repository.HoaDonDoiRepository;
import com.jpn2018.doidiemservice.service.HoaDonDoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HoaDonDoiServiceImpl implements HoaDonDoiService {

    @Autowired
    private HoaDonDoiRepository hoaDonDoiRepository;

    @Autowired
    private ThanhVienClient thanhVienClient;

    @Autowired
    private DichVuClient dichVuClient;


    @Override
    public HoaDonDoi saveHoaDonDoi(HoaDonDoi hoaDonDoi) {
        System.out.println(hoaDonDoi);
        hoaDonDoi.setDate(LocalDate.now());
//        ThanhVien thanhVien = thanhVienRepository.findById(hoaDonDoi.getThanhVien().getId()).get();
        ThanhVien thanhVien = thanhVienClient.getThanhVienById(hoaDonDoi.getThanhVienId());
        hoaDonDoi.setThanhVienId(thanhVien.getId());
        List<ChiTietDoi> chiTietDoiRequests = hoaDonDoi.getChiTietDois();
        List<ChiTietDoi> chiTietDois = new ArrayList<>();
        int total = 0;
        for (ChiTietDoi chiTietDoiRequest : chiTietDoiRequests) {
            ChiTietDoi chiTietDoi = new ChiTietDoi();
//            DichVu dichVu = dichVuRepository.findById(chiTietDoiRequest.getDichVu().getId()).orElse(null);
            DichVu dichVu = dichVuClient.getDichVuById(chiTietDoiRequest.getDichVuId()); //////////////////////
            if (dichVu != null) {
//                chiTietDoi.setDichVuId(chiTietDoi.getDichVuId());
                chiTietDoi.setDichVuId(dichVu.getId());   ////////////////////////////////////////////////////lateee
                chiTietDoi.setPoint(dichVu.getPoint());
                chiTietDoi.setQuantity(chiTietDoiRequest.getQuantity());
                total += chiTietDoi.getPoint() * chiTietDoi.getQuantity();

                chiTietDois.add(chiTietDoi);
            } else {

                return null;
            }
        }
        thanhVien.setPoint(thanhVien.getPoint() - total);

        return hoaDonDoiRepository.save(hoaDonDoi);
    }

    @Override
    public List<HoaDonDoi> getAllHoaDonDois() {
        return hoaDonDoiRepository.findAll();
    }

    @Override
    public HoaDonDoi getHoaDonDoiById(Long id) {
        Optional<HoaDonDoi> hoaDonDoi = hoaDonDoiRepository.findById(id);
        if (hoaDonDoi.isPresent()) {
            return hoaDonDoi.get();
        } else {
            // Handle not found exception or return null/throw exception
            // For example:
            // throw new NotFoundException("HoaDonDoi not found with ID: " + id);
            return null;
        }
    }

    @Override
    public void deleteHoaDonDoiById(Long id) {
        hoaDonDoiRepository.deleteById(id);
    }

    @Override
    public HoaDonDoi updateHoaDonDoi(Long id, HoaDonDoi hoaDonDoi) {
        Optional<HoaDonDoi> existingHoaDonDoi = hoaDonDoiRepository.findById(id);
        if (existingHoaDonDoi.isPresent()) {
            HoaDonDoi updatedHoaDonDoi = existingHoaDonDoi.get();
            updatedHoaDonDoi.setDate(hoaDonDoi.getDate());
            updatedHoaDonDoi.setThanhVienId(hoaDonDoi.getThanhVienId());
            updatedHoaDonDoi.setChiTietDois(hoaDonDoi.getChiTietDois());
            // Set other attributes accordingly

            return hoaDonDoiRepository.save(updatedHoaDonDoi);
        } else {
            // Handle not found exception or return null/throw exception
            // For example:
            // throw new NotFoundException("HoaDonDoi not found with ID: " + id);
            return null;
        }
    }
}
