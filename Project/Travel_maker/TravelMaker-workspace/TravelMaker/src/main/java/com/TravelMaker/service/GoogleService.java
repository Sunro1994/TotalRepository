package com.TravelMaker.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
public class GoogleService {
	public HashMap<String, String> getToken(String code) {
		
		
		/* 필요 Data */
		String client_id = "1051611122531-fpva2ogee41oq126prt05gnvfa2uc6it.apps.googleusercontent.com";
		String client_secret = "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";
		String redirect_uri= "http://localhost:8080/www/Member/GoogleLogin";
		
		String reqURL = "https://oauth2.googleapis.com/token";
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		
		/* body data 생성 */ 
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
	        System.out.println(resMap);
	        
	        String access_token = resMap.get("access_token");

		    String userInfoURL = "https://www.googleapis.com/userinfo/v2/me";
		    // Header에 access_token 삽입
		    headers.set("Authorization", "Bearer "+access_token);

		    // Request entity 생성
		    HttpEntity<?> userInfoEntity = new HttpEntity<>(headers);
		    
		    // GET 방식으로 Http 요청
		    // 응답 데이터 형식은 Hashmap 으로 지정
		    ResponseEntity<HashMap> userResult = restTemplate.exchange(userInfoURL, HttpMethod.GET, userInfoEntity, HashMap.class);
		    Map<String, String> userResultMap = userResult.getBody();

		    //응답 데이터 확인
//		    System.out.println("userResult  : " + userResultMap);
//		    System.out.println(userResultMap.get("name"));
//		    System.out.println(userResultMap.get("id"));
//		    System.out.println(userResultMap.get("email"));
//		    System.out.println(userResultMap.get("picture"));
		    
			// 응답 데이터 확인
//	        System.out.println(resMap);
		    
		    //결과를 담을 해쉬맵
			resultMap.put("name", userResultMap.get("name").toString());
			resultMap.put("id", userResultMap.get("id").toString());
			resultMap.put("email", userResultMap.get("email").toString());
			resultMap.put("picture", userResultMap.get("picture").toString());
			resultMap.put("token", access_token);
		    
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	   

	    return resultMap ;
	}

	public HashMap<String, String> getToken2(String code) {

		String client_id = "1051611122531-fpva2ogee41oq126prt05gnvfa2uc6it.apps.googleusercontent.com";
		String client_secret = "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";
		String redirect_uri= "http://localhost:8080/www/Member/GoogleJoin";
		
		String reqURL = "https://oauth2.googleapis.com/token";
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		
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
	        System.out.println(resMap);
	        
	        String access_token = resMap.get("access_token");

		    String userInfoURL = "https://www.googleapis.com/userinfo/v2/me";
		    // Header에 access_token 삽입
		    headers.set("Authorization", "Bearer "+access_token);

		    // Request entity 생성
		    HttpEntity<?> userInfoEntity = new HttpEntity<>(headers);
		    
		    // GET 방식으로 Http 요청
		    // 응답 데이터 형식은 Hashmap 으로 지정
		    ResponseEntity<HashMap> userResult = restTemplate.exchange(userInfoURL, HttpMethod.GET, userInfoEntity, HashMap.class);
		    Map<String, String> userResultMap = userResult.getBody();

		    //응답 데이터 확인
//		    System.out.println("userResult  : " + userResultMap);
//		    System.out.println(userResultMap.get("name"));
//		    System.out.println(userResultMap.get("id"));
//		    System.out.println(userResultMap.get("email"));
//		    System.out.println(userResultMap.get("picture"));
		    
			// 응답 데이터 확인
//	        System.out.println(resMap);
		    
		  //결과를 담을 해쉬맵
			resultMap.put("name", userResultMap.get("name").toString());
			resultMap.put("id", userResultMap.get("id").toString());
			resultMap.put("email", userResultMap.get("email").toString());
			resultMap.put("picture", userResultMap.get("picture").toString());
		    
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	   

	    return resultMap ;
		
	}

	
}



