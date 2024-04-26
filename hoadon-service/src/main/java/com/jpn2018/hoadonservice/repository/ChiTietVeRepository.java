package com.jpn2018.hoadonservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpn2018.hoadonservice.entity.ChiTietVe;

@Repository
public interface ChiTietVeRepository extends JpaRepository<ChiTietVe, Long>{

}
