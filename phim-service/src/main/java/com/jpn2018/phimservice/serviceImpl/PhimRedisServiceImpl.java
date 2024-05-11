package com.jpn2018.phimservice.serviceImpl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpn2018.phimservice.entity.Phim;
import com.jpn2018.phimservice.service.PhimRedisService;

@Service
public class PhimRedisServiceImpl implements PhimRedisService{
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private ObjectMapper redisObjectMapper;
	@Override
	public Phim getPhimById(Long id) throws JsonMappingException, JsonProcessingException {
		String key = "phim:" + id;
		String json = (String) redisTemplate.opsForValue().get(key);
		return json == null? null: redisObjectMapper.readValue(json, Phim.class);
	}
	@Override
	public void savePhim(Phim phim) throws JsonProcessingException {
		String key = "phim:" + phim.getId();
		String json = redisObjectMapper.writeValueAsString(phim);
		redisTemplate.opsForValue().set(key, json);
		redisTemplate.expire(key, Duration.ofMinutes(1));
	}
	@Override
	public void deletePhim(Long id) {
		String key = "phim:" + id;
		redisTemplate.delete(key);
	}
}
