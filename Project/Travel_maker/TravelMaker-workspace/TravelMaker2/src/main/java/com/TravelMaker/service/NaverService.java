package com.TravelMaker.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NaverService {

	public String getToken(String code) {
		String access_token = "";
		
		//입력할 정보
		String requrl = "https://nid.naver.com/oauth2.0/token?";
		String grant_type = "grant_type=authorization_code";
		String client_id = "&client_id=90TeRuXWOlklHroO_ywb";
		String client_secret = "&client_secret=SKwEKlowlR";
		String setCode = "&code="+code;
		String state = "&state=123456";
		String line = "";
		String result = "";
		
		try {
			URL url = new URL(requrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append(grant_type);
			sb.append(client_id);
			sb.append(client_secret);
			sb.append(setCode);
			sb.append(state);
			
			bw.write(sb.toString());
			bw.flush();
			
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			

			while ((line = br.readLine()) != null) {
				result += line;
			}
			
			// jackson objectmapper 객체 생성
						ObjectMapper objectMapper = new ObjectMapper();
			// JSON String -> Map
			Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
			});

			access_token = jsonMap.get("access_token").toString();


			br.close();
			bw.close();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		return access_token;
	}
	
	public HashMap<String, String> getUserInfo(String token) throws IOException {

		HashMap<String, String> userInfo = new HashMap<String, String>();
		String reqURL = "https://openapi.naver.com/v1/nid/me";

		URL url = new URL(reqURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		// 요청에 필요한 Header에 포함될 내용
		conn.setRequestProperty("Authorization", "Bearer " + token);

		int responseCode = conn.getResponseCode();
		System.out.println("responseCode : " + responseCode);

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String line = "";
		String result = "";

		while ((line = br.readLine()) != null) {
			result += line;
		}

		try {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
		});
		
		HashMap<String, String> jsonMap2 = (HashMap<String, String>) jsonMap.get("response");
//		
		System.out.println(jsonMap2);
		userInfo.put("id", jsonMap2.get("id").toString());
		userInfo.put("email", jsonMap2.get("email").toString());
		userInfo.put("mobile", jsonMap2.get("mobile").toString());
		userInfo.put("nickname", jsonMap2.get("nickname").toString());
	

	}catch(

	Exception e)
	{
		e.printStackTrace();
	}

	
	
	return userInfo;

}

	public String getToken2(String code) {
		String access_token = "";
		
		//입력할 정보
		String requrl = "https://nid.naver.com/oauth2.0/token?";
		String grant_type = "grant_type=authorization_code";
		String client_id = "&client_id=90TeRuXWOlklHroO_ywb";
		String client_secret = "&client_secret=SKwEKlowlR";
		String setCode = "&code="+code;
		String state = "&state=123456";
		String line = "";
		String result = "";
		
		try {
			URL url = new URL(requrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append(grant_type);
			sb.append(client_id);
			sb.append(client_secret);
			sb.append(setCode);
			sb.append(state);
			
			bw.write(sb.toString());
			bw.flush();
			
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			

			while ((line = br.readLine()) != null) {
				result += line;
			}
			
			// jackson objectmapper 객체 생성
						ObjectMapper objectMapper = new ObjectMapper();
			// JSON String -> Map
			Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
			});

			access_token = jsonMap.get("access_token").toString();


			br.close();
			bw.close();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		return access_token;
	}
	
	public HashMap<String, String> getUserInfo2(String token) throws IOException {

		HashMap<String, String> userInfo = new HashMap<String, String>();
		String reqURL = "https://openapi.naver.com/v1/nid/me";

		URL url = new URL(reqURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		// 요청에 필요한 Header에 포함될 내용
		conn.setRequestProperty("Authorization", "Bearer " + token);

		int responseCode = conn.getResponseCode();
		System.out.println("responseCode : " + responseCode);

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String line = "";
		String result = "";

		while ((line = br.readLine()) != null) {
			result += line;
		}

		try {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
		});
		
		HashMap<String, String> jsonMap2 = (HashMap<String, String>) jsonMap.get("response");
//		
		System.out.println(jsonMap2);
		userInfo.put("id", jsonMap2.get("id").toString());
		userInfo.put("email", jsonMap2.get("email").toString());
		userInfo.put("mobile", jsonMap2.get("mobile").toString());
		userInfo.put("nickname", jsonMap2.get("nickname").toString());
	

	}catch(

	Exception e)
	{
		e.printStackTrace();
	}

	
	
	return userInfo;

}

	/**
	 * https://nid.naver.com/oauth2.0/token?
	 * grant_type=delete
	 * &client_id=jyvqXeaVOVmV
	 * &client_secret=527300A0_COq1_XV33cf
	 * &access_token=c8ceMEJisO4Se7uGCEYKK1p52L93bHXLnaoETis9YzjfnorlQwEisqemfpKHUq2gY
	 * &service_provider=NAVER
	 * @param access_token
	 */
	public void logout(String token) {
	    String reqURL = "https://nid.naver.com/oauth2.0/token?";
	    String grant_type= "grant_type=delete";
	    String client_id="&client_id=90TeRuXWOlklHroO_ywb";
	    String client_secret="&client_secret=SKwEKlowlR";
	    String access_token="&access_token="+token;
	    String service_provider="&service_provider=NAVER";
	    reqURL += grant_type+ client_id + client_secret + access_token + service_provider;
	    
	    try {
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET"); // HTTP POST 메서드를 사용하도록 변경

	        int responseCode = conn.getResponseCode();
	        System.out.println("네이버 탈퇴 요청 responseCode: " + responseCode);

	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	        String result = "";
	        String line = "";

	        while ((line = br.readLine()) != null) {
	            result += line;
	        }
	        
	        System.out.println(result);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	
	
	
}
