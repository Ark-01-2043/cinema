package com.jpn2018.lichchieuservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpn2018.lichchieuservice.entity.LichChieu;
@Repository
public interface LichChieuRepository extends JpaRepository<LichChieu, Long>{
	List<LichChieu> findByPhimId(Long phimId);
}
