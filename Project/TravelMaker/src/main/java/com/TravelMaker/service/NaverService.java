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

	public String getTokenForJoin(String code) {
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
			//출력 스트림의 사용, 연결이 출력 데이터를 전송할 수 있도록 함
			conn.setDoOutput(true);

			//OutputStreamWriter로 래핑하고 효율적인 전송을 위해 BufferedWriter로 다시 래핑
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

			//OAuth 요청 매개변수 설정(페이로드 구성)
			StringBuilder sb = new StringBuilder();
			sb.append(grant_type);
			sb.append(client_id);
			sb.append(client_secret);
			sb.append(setCode);
			sb.append(state);

			//문자열로 변환후 출력 스트림에 기록
			bw.write(sb.toString());
			//남아있는 데이터를 강제로 출력(데이터를 완전히 보내기 위함)
			bw.flush();
			
			int responseCode = conn.getResponseCode();
			//
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			

			while ((line = br.readLine()) != null) {
				result += line;
			}
			
			// jackson objectmapper 객체 생성
						ObjectMapper objectMapper = new ObjectMapper();
			// JSON String 을 Map타입으로 받기
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
	
	public HashMap<String, String> getInfoForJoin(String token) throws IOException {

		HashMap<String, String> userInfo = new HashMap<String, String>();
		String reqURL = "https://openapi.naver.com/v1/nid/me";

		URL url = new URL(reqURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		// 요청에 필요한 Header에 포함될 내용
		conn.setRequestProperty("Authorization", "Bearer " + token);
		int responseCode = conn.getResponseCode();

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String line = "";
		StringBuilder result = new StringBuilder();
		while ((line = br.readLine()) != null) {
            result.append(line);	}

		try {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> jsonMap = objectMapper.readValue(result.toString(), new TypeReference<Map<String, Object>>() {
		});

		@SuppressWarnings("unchecked")
		HashMap<String, Object> jsonMap2 = (HashMap<String, Object>) jsonMap.get("response");
		userInfo.put("id", jsonMap2.get("id").toString());
		userInfo.put("email", jsonMap2.get("email").toString());
		userInfo.put("mobile", jsonMap2.get("mobile").toString());
		userInfo.put("nickname", jsonMap2.get("nickname").toString());
	

	}catch(	Exception e)
	{
		e.printStackTrace();
	}

	
	
	return userInfo;

}

	public String getTokenForLogin(String code) {
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
	
	public HashMap<String, String> getUserInfoForLogin(String token) throws IOException {

		HashMap<String, String> userInfo = new HashMap<String, String>();
		String reqURL = "https://openapi.naver.com/v1/nid/me";

		URL url = new URL(reqURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		// 요청에 필요한 Header에 포함될 내용
		conn.setRequestProperty("Authorization", "Bearer " + token);

		int responseCode = conn.getResponseCode();

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
	 *
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

	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	        String result = "";
	        String line = "";

	        while ((line = br.readLine()) != null) {
	            result += line;
	        }
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	
	
	
}
