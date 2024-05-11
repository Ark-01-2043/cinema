package com.jpn2018.lichchieuservice.serviceImpl;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpn2018.lichchieuservice.entity.LichChieu;
import com.jpn2018.lichchieuservice.entity.LichChieuFullResponse;
import com.jpn2018.lichchieuservice.service.LichChieuRedisService;

@Service
public class LichChieuRedisServiceImpl implements LichChieuRedisService{
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private ObjectMapper redisObjectMapper;
	@Override
	public LichChieu getLichChieuByid(Long id) throws JsonMappingException, JsonProcessingException {
		String key = "lichchieu:" + id;
		String json = (String) redisTemplate.opsForValue().get(key);
		return json == null? null: redisObjectMapper.readValue(json, LichChieu.class);
	}
	@Override
	public void saveLichChieu(LichChieu lichChieu) throws JsonProcessingException {
		String key = "lichchieu:" + lichChieu.getId();
		String json = redisObjectMapper.writeValueAsString(lichChieu);
		redisTemplate.opsForValue().set(key, json);
		redisTemplate.expire(key, Duration.ofMinutes(1));
	}
	@Override
	public void deleteLichChieu(Long id) {
		String key = "lichchieu:" + id;
		redisTemplate.delete(key);
	}
	@Override
	public LichChieuFullResponse getLichChieuFullById(Long id) throws JsonMappingException, JsonProcessingException {
		String key = "lichchieufull:" + id;
		String json = (String) redisTemplate.opsForValue().get(key);
		return json == null? null: redisObjectMapper.readValue(json, LichChieuFullResponse.class);
	}
	@Override
	public void saveLichChieuFull(LichChieuFullResponse lichChieuFullResponse) throws JsonProcessingException {
		String key = "lichchieufull:" + lichChieuFullResponse.getId();
		String json = redisObjectMapper.writeValueAsString(lichChieuFullResponse);
		redisTemplate.opsForValue().set(key, json);
		redisTemplate.expire(key, Duration.ofMinutes(1));
	}
	@Override
	public List<LichChieuFullResponse> getDSLichChieuByPhim(Long phimId) throws JsonMappingException, JsonProcessingException{
		String key = "lichchieu:phim:" + phimId;
		String json = (String) redisTemplate.opsForValue().get(key);
		return json == null? null: redisObjectMapper.readValue(json, new TypeReference<List<LichChieuFullResponse>>() {});
	}
	@Override
	public void saveDSLichChieuByPhim(List<LichChieuFullResponse> lichChieuFullResponses) throws JsonProcessingException {
		String key = "lichchieu:phim:" + lichChieuFullResponses.get(0).getPhim().getId();
		String json = redisObjectMapper.writeValueAsString(lichChieuFullResponses);
		redisTemplate.opsForValue().set(key, json);
		redisTemplate.expire(key, Duration.ofMinutes(1));
	}
}
