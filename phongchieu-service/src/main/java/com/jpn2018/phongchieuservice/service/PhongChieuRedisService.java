package com.jpn2018.phongchieuservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpn2018.phongchieuservice.entity.PhongChieu;

public interface PhongChieuRedisService {

	void deletePhongChieu(Long id);

	void savePhongChieu(PhongChieu phongChieu) throws JsonProcessingException;

	PhongChieu getPhongChieuById(Long id) throws JsonMappingException, JsonProcessingException;

}
