package com.jpn2018.veservice.serviceImpl;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpn2018.veservice.dto.VeFullResponse;
import com.jpn2018.veservice.entity.Ve;
import com.jpn2018.veservice.service.VeRedisService;

@Service
public class VeRedisServiceImpl implements VeRedisService{
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private ObjectMapper redisObjectMapper;
	@Override
	public Ve getVeById(Long id) throws JsonMappingException, JsonProcessingException {
		String key = "ve:" + id;
		String json = (String) redisTemplate.opsForValue().get(key);
		return json == null? null : redisObjectMapper.readValue(json, Ve.class);
	}
	@Override
	public void saveVe(Ve ve) throws JsonProcessingException {
		String key = "ve:" + ve.getId();
		String json = redisObjectMapper.writeValueAsString(ve);
		redisTemplate.opsForValue().set(key, json);
		redisTemplate.expire(key, Duration.ofMinutes(1));
	}
	@Override
	public void deleteVe(Long id) {
		String key = "ve:" + id;
		redisTemplate.delete(key);
	}
	@Override
	public List<VeFullResponse> getDSVeByLichChieu(Long lichChieuId) throws JsonMappingException, JsonProcessingException {
		String key = "ve:lichchieu:" + lichChieuId;
		String json = (String) redisTemplate.opsForValue().get(key);
		return json == null? null: redisObjectMapper.readValue(json, new TypeReference<List<VeFullResponse>>() {});
	}
	@Override
	public void saveDSVeByLichChieu(List<VeFullResponse> list) throws JsonProcessingException {
		String key = "ve:lichchieu:" + list.get(0).getLichChieu().getId();
		String json = redisObjectMapper.writeValueAsString(list);
		redisTemplate.opsForValue().set(key, json);
		redisTemplate.expire(key, Duration.ofMinutes(1));
	}
}
