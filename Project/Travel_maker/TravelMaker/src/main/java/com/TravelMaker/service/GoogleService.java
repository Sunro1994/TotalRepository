package com.TravelMaker.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GoogleService {
	public String getToken(String code) {
		String client_id = "1051611122531-fpva2ogee41oq126prt05gnvfa2uc6it.apps.googleusercontent.com";
		String client_secret = "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";
		String redirect_uri= "http://localhost:8080/www/Member/GoogleLogin";
		
		String reqURL = "https://oauth2.googleapis.com/token";

		
		
		// body data 생성
	    MultiValueMap<String, String> parameter = new LinkedMultiValueMap<>();
	    parameter.add("grant_type", "authorization_code");
	    parameter.add("client_id", client_id);
	    parameter.add("client_secret", client_secret);
	    parameter.add("code", code);
	    parameter.add("redirect_uri", redirect_uri);

	    // request header 설정
	    org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
	    // Content-type을 application/x-www-form-urlencoded 로 설정
	    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

	    // header 와 body로 Request 생성
	    HttpEntity<?> entity = new HttpEntity(parameter, headers);

	    try {
	        RestTemplate restTemplate = new RestTemplate();
	        // 응답 데이터(json)를 Map 으로 받을 수 있도록 관련 메시지 컨버터 추가
	        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

	        // Post 방식으로 Http 요청
	        // 응답 데이터 형식은 Hashmap 으로 지정
	        ResponseEntity<HashMap> result = restTemplate.postForEntity(reqURL, entity, HashMap.class);
	        Map<String, String> resMap = result.getBody();

			// 응답 데이터 확인
	        System.out.println(resMap);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "/sns/sns_result";
	}
}



