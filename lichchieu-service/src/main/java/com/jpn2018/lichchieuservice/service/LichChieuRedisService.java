package com.jpn2018.lichchieuservice.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpn2018.lichchieuservice.entity.LichChieu;
import com.jpn2018.lichchieuservice.entity.LichChieuFullResponse;

public interface LichChieuRedisService {

	LichChieu getLichChieuByid(Long id) throws JsonMappingException, JsonProcessingException;

	void saveLichChieu(LichChieu lichChieu) throws JsonProcessingException;

	void deleteLichChieu(Long id);

	LichChieuFullResponse getLichChieuFullById(Long id) throws JsonMappingException, JsonProcessingException;

	void saveLichChieuFull(LichChieuFullResponse lichChieuFullResponse) throws JsonProcessingException;

	void saveDSLichChieuByPhim(List<LichChieuFullResponse> lichChieuFullResponses) throws JsonProcessingException;

	List<LichChieuFullResponse> getDSLichChieuByPhim(Long phimId) throws JsonMappingException, JsonProcessingException;

}
