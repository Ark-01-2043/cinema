package com.jpn2018.veservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpn2018.veservice.entity.Ve;

@Repository
public interface VeRepository extends JpaRepository<Ve, Long>{
	List<Ve> findByLichChieuId(Long lichChieuId);
}
