package com.jpn2018.dichvuservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpn2018.dichvuservice.entity.DichVu;

public interface DichVuRedisService {

	void deleteDichVu(Long id);

	void saveDichVu(DichVu dichVu) throws JsonProcessingException;

	DichVu getDichVuById(Long id) throws JsonMappingException, JsonProcessingException;

}
