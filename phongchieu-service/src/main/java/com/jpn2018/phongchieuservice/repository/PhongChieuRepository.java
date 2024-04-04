package com.jpn2018.phongchieuservice.repository;

import com.jpn2018.phongchieuservice.entity.PhongChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhongChieuRepository extends JpaRepository<PhongChieu, Long> {
    List<PhongChieu> findAllByRapId(Long rapId);
}
