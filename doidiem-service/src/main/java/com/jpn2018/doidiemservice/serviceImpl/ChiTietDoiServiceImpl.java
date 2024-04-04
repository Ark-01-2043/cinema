package com.jpn2018.doidiemservice.serviceImpl;

import com.jpn2018.doidiemservice.entity.ChiTietDoi;
import com.jpn2018.doidiemservice.repository.ChiTietDoiRepository;
import com.jpn2018.doidiemservice.service.ChiTietDoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietDoiServiceImpl implements ChiTietDoiService {

    @Autowired
    ChiTietDoiRepository chiTietDoiRepository;

    @Override
    public ChiTietDoi saveChiTietDoi(ChiTietDoi chiTietDoi) {
        return chiTietDoiRepository.save(chiTietDoi);
    }

    @Override
    public List<ChiTietDoi> getListChiTietDoi() {
        return chiTietDoiRepository.findAll();
    }

    @Override
    public ChiTietDoi getChiTietDoiById(Long chiTietDoiId) {
        Optional<ChiTietDoi> chiTietDoi = chiTietDoiRepository.findById(chiTietDoiId);
        if (!chiTietDoi.isPresent()) {
            //exception
            System.out.println("chi tiet doi not found");
        }
        return chiTietDoi.get();
    }

    @Override
    public void deleteChiTietDoiById(Long chiTietDoiId) {
        chiTietDoiRepository.deleteById(chiTietDoiId);
    }

    @Override
    public ChiTietDoi updateChiTietDoi(Long chiTietDoiId, ChiTietDoi chiTietDoi) {
        ChiTietDoi oldChiTietDoi = chiTietDoiRepository.findById(chiTietDoiId).get();
        oldChiTietDoi.setPoint(chiTietDoi.getPoint());
        oldChiTietDoi.setQuantity(chiTietDoi.getQuantity());
        oldChiTietDoi.setHoaDonDoi(chiTietDoi.getHoaDonDoi());
        oldChiTietDoi.setDichVuId(chiTietDoi.getDichVuId());
        return chiTietDoiRepository.save(oldChiTietDoi);
    }
}
