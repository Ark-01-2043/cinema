package com.jpn2018.dichvuservice.serviceImpl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpn2018.dichvuservice.entity.DichVu;
import com.jpn2018.dichvuservice.service.DichVuRedisService;

@Service
public class DichVuRedisServiceImpl implements DichVuRedisService{
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private ObjectMapper redisObjectMapper;
	
	@Override
	public DichVu getDichVuById(Long id) throws JsonMappingException, JsonProcessingException {
		String key = "dichvu:" + id;
		String json = (String) redisTemplate.opsForValue().get(key);
		return json==null? null: redisObjectMapper.readValue(json, DichVu.class);
	}
	@Override
	public void saveDichVu(DichVu dichVu) throws JsonProcessingException {
		String key = "dichvu:" + dichVu.getId();
		String json = redisObjectMapper.writeValueAsString(dichVu);
		redisTemplate.opsForValue().set(key, json);
		redisTemplate.expire(key, Duration.ofMinutes(1));
	}
	@Override
	public void deleteDichVu(Long id) {
		String key = "dichvu:" + id;
		redisTemplate.delete(key);
	}
}
