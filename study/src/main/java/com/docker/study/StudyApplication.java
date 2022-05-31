package com.docker.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class StudyApplication {
	@Autowired
	private RedisTemplate<String, Integer> redisTemplate;

	@PostConstruct
	public void init() {
		ValueOperations<String, Integer> valueOperations = redisTemplate.opsForValue();
		valueOperations.set("number", 0);
	}

	@RequestMapping("/")
	public String home() {
		ValueOperations<String, Integer> valueOperations = redisTemplate.opsForValue();
		Integer number = valueOperations.get("number");
		valueOperations.set("number", number + 1);
		return "안녕하세요 숫자 :" + number;
	}

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

}
