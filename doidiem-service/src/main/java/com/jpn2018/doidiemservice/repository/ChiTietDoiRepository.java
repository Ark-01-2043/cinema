package com.jpn2018.doidiemservice.repository;

import com.jpn2018.doidiemservice.entity.ChiTietDoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietDoiRepository extends JpaRepository<ChiTietDoi, Long> {
}
