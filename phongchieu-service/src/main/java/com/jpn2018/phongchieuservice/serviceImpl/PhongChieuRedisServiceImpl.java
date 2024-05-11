package com.jpn2018.phongchieuservice.serviceImpl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpn2018.phongchieuservice.entity.PhongChieu;
import com.jpn2018.phongchieuservice.service.PhongChieuRedisService;
@Service
public class PhongChieuRedisServiceImpl implements PhongChieuRedisService{
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private ObjectMapper redisObjectMapper;
	@Override
	public PhongChieu getPhongChieuById(Long id) throws JsonMappingException, JsonProcessingException {
		String key = "phongchieu:" + id;
		String json = (String) redisTemplate.opsForValue().get(key);
		return json == null? null: redisObjectMapper.readValue(json, PhongChieu.class);
	}
	@Override
	public void savePhongChieu(PhongChieu phongChieu) throws JsonProcessingException {
		String key = "phongchieu:" + phongChieu.getId();
		String json = redisObjectMapper.writeValueAsString(phongChieu);
		redisTemplate.opsForValue().set(key, json);
		redisTemplate.expire(key, Duration.ofMinutes(1));
	}
	@Override
	public void deletePhongChieu(Long id) {
		String key = "phongChieu:" + id;
		redisTemplate.delete(key);
	}
}
