package com.jpn2018.phimservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpn2018.phimservice.entity.Phim;

public interface PhimRedisService {

	Phim getPhimById(Long id) throws JsonMappingException, JsonProcessingException;

	void savePhim(Phim phim) throws JsonProcessingException;

	void deletePhim(Long id);

}
