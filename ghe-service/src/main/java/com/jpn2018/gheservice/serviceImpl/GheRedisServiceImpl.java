package com.jpn2018.gheservice.serviceImpl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpn2018.gheservice.entity.Ghe;
import com.jpn2018.gheservice.service.GheRedisService;

@Service
public class GheRedisServiceImpl implements GheRedisService{
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private ObjectMapper redisObjectMapper;
	@Override
	public Ghe getGheById(Long id) throws JsonMappingException, JsonProcessingException {
		String key = "ghe:" + id;
		String json = (String) redisTemplate.opsForValue().get(key);
		return json == null? null: redisObjectMapper.readValue(json, Ghe.class);
	}
	@Override
	public void saveGhe(Ghe ghe) throws JsonProcessingException {
		String key = "ghe:" + ghe.getId();
		String json = redisObjectMapper.writeValueAsString(ghe);
		redisTemplate.opsForValue().set(key, json);
		redisTemplate.expire(key, Duration.ofMinutes(1));
	}
	@Override
	public void deleteGhe(Long id) {
		String key = "ghe:" + id;
		redisTemplate.delete(key);
	}
}
