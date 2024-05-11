package com.jpn2018.thanhvienservice.controller;

import com.jpn2018.thanhvienservice.entity.ThanhVien;
import com.jpn2018.thanhvienservice.error.ThanhVienNotFoundException;
import com.jpn2018.thanhvienservice.service.ThanhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thanhviens")
@CrossOrigin(origins = "http://localhost:3000")
public class ThanhVienController {

    @Autowired
    private ThanhVienService thanhVienService;

    @PostMapping
    public ThanhVien createThanhVien(@RequestBody ThanhVien thanhVien) {
        return thanhVienService.saveThanhVien(thanhVien);
    }

    @PostMapping("/login")
    public ThanhVien login(@RequestBody ThanhVien thanhVien) throws ThanhVienNotFoundException {
        return thanhVienService.login(thanhVien);
    }

    @GetMapping("/{email}")
    public ThanhVien getThanhVienByEmail(@PathVariable String email) throws ThanhVienNotFoundException {
        return thanhVienService.getThanhVienByEmail(email);
    }

    @GetMapping
    public List<ThanhVien> getAllThanhViens() {
        return thanhVienService.getAllThanhViens();
    }

    @GetMapping("/id/{id}")
    public ThanhVien getThanhVienById(@PathVariable Long id) throws ThanhVienNotFoundException {
        return thanhVienService.getThanhVienById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteThanhVien(@PathVariable Long id) {
        thanhVienService.deleteThanhVienById(id);
        return "Deleted ThanhVien with ID: " + id;
    }

//    @PutMapping("/{id}")
//    public ThanhVien updateThanhVien(@PathVariable Long id, @RequestBody ThanhVien thanhVien) {
//        return thanhVienService.updateThanhVien(id, thanhVien);
//    }

//    @PatchMapping
//    public ResponseEntity<?> changePassword(
//            @RequestBody ChangePasswordRequest request,
//            Principal connectedUser
//    ) {
//        thanhVienService.changePassword(request, connectedUser);
//        return ResponseEntity.ok().build();
//    }
}
