package com.jpn2018.khunggioservice.serviceImpl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpn2018.khunggioservice.entity.KhungGio;
import com.jpn2018.khunggioservice.service.KhungGioRedisService;

@Service
public class KhungGioRedisServiceImpl implements KhungGioRedisService{
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private ObjectMapper redisObjectMapper;
	@Override
	public KhungGio getKhungGioById(Long id) throws JsonMappingException, JsonProcessingException {
		String key = "khunggio:" + id;
		String json = (String) redisTemplate.opsForValue().get(key);
		return json == null? null: redisObjectMapper.readValue(json, KhungGio.class);
	}
	@Override
	public void saveKhungGio(KhungGio khungGio) throws JsonProcessingException {
		String key = "khunggio:" + khungGio.getId();
		String json = redisObjectMapper.writeValueAsString(khungGio);
		redisTemplate.opsForValue().set(key, json);
		redisTemplate.expire(key, Duration.ofMinutes(1));
	}
	@Override
	public void deleteKhungGio(Long id) {
		String key = "khunggio:" + id;
		redisTemplate.delete(key);
	}
}
