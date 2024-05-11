package com.jpn2018.veservice.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpn2018.veservice.dto.VeFullResponse;
import com.jpn2018.veservice.entity.Ve;

public interface VeRedisService {

	Ve getVeById(Long id) throws JsonMappingException, JsonProcessingException;

	void saveVe(Ve ve) throws JsonProcessingException;

	void deleteVe(Long id);

	List<VeFullResponse> getDSVeByLichChieu(Long lichChieuId) throws JsonMappingException, JsonProcessingException;

	void saveDSVeByLichChieu(List<VeFullResponse> list) throws JsonProcessingException;

	

}
