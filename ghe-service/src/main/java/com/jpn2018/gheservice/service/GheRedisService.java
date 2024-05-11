package com.jpn2018.gheservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpn2018.gheservice.entity.Ghe;

public interface GheRedisService {

	void deleteGhe(Long id);

	void saveGhe(Ghe ghe) throws JsonProcessingException;

	Ghe getGheById(Long id) throws JsonMappingException, JsonProcessingException;

}
