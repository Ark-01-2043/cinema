package com.jpn2018.phimservice.repository;

import com.jpn2018.phimservice.entity.Phim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhimRepository extends JpaRepository<Phim, Long> {
}
