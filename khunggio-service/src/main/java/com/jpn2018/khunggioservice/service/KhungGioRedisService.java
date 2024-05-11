package com.jpn2018.khunggioservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpn2018.khunggioservice.entity.KhungGio;

public interface KhungGioRedisService {

	KhungGio getKhungGioById(Long id) throws JsonMappingException, JsonProcessingException;

	void saveKhungGio(KhungGio khungGio) throws JsonProcessingException;

	void deleteKhungGio(Long id);

}
