package com.jpn2018.hoadonservice.serviceImpl;

import com.jpn2018.hoadonservice.client.*;
import com.jpn2018.hoadonservice.dto.EmailRequest;
import com.jpn2018.hoadonservice.dto.HoaDonDto;
import com.jpn2018.hoadonservice.dto.Ve;
import com.jpn2018.hoadonservice.entity.ChiTietVe;
import com.jpn2018.hoadonservice.entity.HoaDon;
import com.jpn2018.hoadonservice.exception.ThanhVienNotFoundException;
import com.jpn2018.hoadonservice.repository.ChiTietDichVuRepository;
import com.jpn2018.hoadonservice.repository.ChiTietVeRepository;
import com.jpn2018.hoadonservice.repository.HoaDonRepository;
import com.jpn2018.hoadonservice.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    private ThanhVienClient thanhVienClient;

    @Autowired
    private VeClient veClient;

    @Autowired
    private DichVuClient dichVuClient;

    @Autowired
    private EmailServiceClient emailServiceClient;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private ChiTietVeRepository chiTietVeRepository;

    @Autowired
    private ChiTietDichVuRepository chiTietDichVuRepository;

    @Autowired
    private ProgressClient progressClient;


    @Override
    public HoaDon saveHoaDon(HoaDon hoaDon) {
        try {
            hoaDon.setDate(LocalDate.now());
            System.out.println(hoaDon);

            List<ChiTietVe> chiTietVes = hoaDon.getChiTietVes();
            for (ChiTietVe chiTietVe : chiTietVes) {
                try {
                    Ve ve = veClient.getVeById(chiTietVe.getVeId());
                    ve.setBooked(true);
                    Ve veUpdate = veClient.updateVe(ve.getId(), ve);
                    progressClient.sendProgress("PUT", 200, "update ticket id: " + chiTietVe.getVeId(), 25);
                } catch (Exception e) {
                    progressClient.sendProgress("PUT", 404, "error update ticket id: " + chiTietVe.getVeId(), 25);
                    System.err.println("Error updating ticket: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Error saving order: " + e.getMessage());
            return null;
        }

        HoaDon savedHoaDon;
        try {
            savedHoaDon = hoaDonRepository.save(hoaDon);
            progressClient.sendProgress("POST", 200, "save bill: " + savedHoaDon.getId(), 50);
        } catch (Exception e) {
            System.err.println("Error saving bill: " + e.getMessage());
            progressClient.sendProgress("POST", 404, "can't save bill, something went wrong", 50);
            return null;
        }

        String clientEmail;
        try {
            clientEmail = thanhVienClient.getThanhVienById(hoaDon.getThanhVienId()).getEmail();
            progressClient.sendProgress("GET", 200, "check client is exist", 75);

        } catch (Exception e) {
            System.err.println("Error find client: " + e.getMessage());
            progressClient.sendProgress("GET", 404, "can't find client, something went wrong", 75);
            return null;
        }

        try {

//            String clientEmail = thanhVienClient.getThanhVienById(hoaDon.getThanhVienId()).getEmail();
            EmailRequest emailRequest = new EmailRequest(clientEmail, "buy ticket successfully", savedHoaDon.toString());

            emailServiceClient.sendEmail(emailRequest);
            progressClient.sendProgress("POST", 200, "send email to client", 100);
        } catch (Exception e) {
            System.err.println("Error sending email: " + e.getMessage());
            progressClient.sendProgress("POST", 404, "can't send email to client, something went wrong", 100);
            return null;
        }

        return savedHoaDon;

    }


    @Override
    public List<HoaDon> getAllHoaDons() {
        return hoaDonRepository.findAll();
    }

    @Override
    public HoaDon getHoaDonById(Long id) {
        Optional<HoaDon> hoaDon = hoaDonRepository.findById(id);
        if (hoaDon.isPresent()) {
            return hoaDon.get();
        } else {
            // Handle not found exception or return null/throw exception
            // For example:
            // throw new NotFoundException("HoaDon not found with ID: " + id);
            return null;
        }
    }

    @Override
    public void deleteHoaDonById(Long id) {
        hoaDonRepository.deleteById(id);
    }

    @Override
    public HoaDon updateHoaDon(Long id, HoaDon hoaDon) {
        Optional<HoaDon> existingHoaDon = hoaDonRepository.findById(id);
        if (existingHoaDon.isPresent()) {


            return hoaDonRepository.save(hoaDon);
        } else {

            return null;
        }
    }


    @Override
    public HoaDonDto toDto(HoaDon hoaDon) throws ThanhVienNotFoundException {
        // TODO Auto-generated method stub
        return HoaDonDto.builder().date(hoaDon.getDate())
                .dichVus(dichVuClient.getAllDichVus())
                .hinhThucThanhToan(null)
                .thanhVien(thanhVienClient.getThanhVienById(hoaDon.getThanhVienId()))
                .ves(hoaDon.getChiTietVes().stream().map((item) -> veClient.getVeById(item.getVeId())).toList())
                .dichVus(hoaDon.getChiTietDichVus().stream().map((item) -> dichVuClient.getDichVuById(item.getDichVuId())).toList())
                .build();

    }

    @Override
    public List<HoaDonDto> getAllDtos() throws ThanhVienNotFoundException {
        // TODO Auto-generated method stub3
        try {
            return hoaDonRepository.findAll().stream().map((item) -> {
                try {
                    return toDto(item);
                } catch (ThanhVienNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
                }
            }).toList();
        } catch (Exception e) {
            // TODO: handle exception
            throw new ThanhVienNotFoundException("Kho");
        }

    }


    @Override
    public HoaDonDto getDtoById(Long id) throws ThanhVienNotFoundException {
        // TODO Auto-generated method stub
        Optional<HoaDon> existingHoaDon = hoaDonRepository.findById(id);
        if (existingHoaDon.isPresent()) {


            return toDto(existingHoaDon.get());
        } else {

            return null;
        }
    }


    @Override
    public HoaDonDto datVe(HoaDon hoaDon) throws ThanhVienNotFoundException {
        // TODO Auto-generated method stub
//		ThanhVien thanhVien = thanhVienClient.getThanhVienById(thanhVienId);
//		HoaDon hoaDon = HoaDon.builder().date(LocalDate.now())
//				.hinhThucThanhToanId(0)
//				.thanhVienId(thanhVienId)
//				.chiTietDichVus(new ArrayList<ChiTietDichVu>())
//				.chiTietVes(new ArrayList<ChiTietVe>())
//				.build();
//		HoaDon savedHoaDon = hoaDonRepository.save(hoaDon);
//		ves.stream().forEach((item) -> {
//			ChiTietVe chiTietVe = ChiTietVe.builder().hoaDon(savedHoaDon)
//									.veId(item)
//									.build();
//			chiTietVeRepository.save(chiTietVe);
//		});
//		dichvus.stream().forEach((item) -> {
//			ChiTietDichVu chiTietDichVu = ChiTietDichVu.builder().dichVuId(item)
//											.hoaDon(savedHoaDon)
//											.quantity(1)
//											.price()
//											.build();
//			chiTietDichVuRepository.save(chiTietDichVu);
//		});
        hoaDon.setDate(LocalDate.now());
        HoaDon savedHoaDon = hoaDonRepository.save(hoaDon);
        return HoaDonDto.builder().date(savedHoaDon.getDate())
                .dichVus(savedHoaDon.getChiTietDichVus().stream().map((item) -> dichVuClient.getDichVuById(item.getDichVuId())).toList())
                .ves(savedHoaDon.getChiTietVes().stream().map((item) -> veClient.getVeById(item.getVeId())).toList())
//				.thanhVien(thanhVien)
                .thanhVien(thanhVienClient.getAllThanhViens().stream().filter((item) -> item.getId() == savedHoaDon.getThanhVienId()).toList().get(0))
                .build();
    }
}
