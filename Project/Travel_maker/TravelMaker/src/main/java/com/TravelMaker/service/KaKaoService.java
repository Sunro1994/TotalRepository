package com.TravelMaker.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelMaker.component.FileComponent;
import com.TravelMaker.component.HashComponent;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KaKaoService {

	@Autowired private HashComponent hashComponent;
	@Autowired private FileComponent fileComponent;
	
	public String getToken(String code) {
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// POST 요청을 위해 기본값이 false인 setDoOutput을 true로
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			// POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=9810e4d47aa744b120cb9d4c343b295f"); // TODO REST_API_KEY 입력
			sb.append("&redirect_uri=http://localhost:8080/www/Member/KaKaoLogin"); // TODO 인가코드 받은 redirect_uri 입력
			sb.append("&code=" + code );
			bw.write(sb.toString());
			bw.flush();

			// 결과 코드가 200이라면 성공
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			// 요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);

			// jackson objectmapper 객체 생성
			ObjectMapper objectMapper = new ObjectMapper();
			// JSON String -> Map
			Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
			});

			access_Token = jsonMap.get("access_token").toString();
			refresh_Token = jsonMap.get("refresh_token").toString();

			System.out.println("access_token : " + access_Token);
			System.out.println("refresh_token : " + refresh_Token);

			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_Token;
		
	}
	public HashMap<String, String> getUserInfo(String token) throws IOException {

		HashMap<String, String> userInfo = new HashMap<String, String>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";

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
		System.out.println("responseBody : " + result);
		System.out.println("result type" + result.getClass().getName());

		try {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
		});

		System.out.println(jsonMap.get("properties"));
		Map<String, Object> properties = (Map<String, Object>) jsonMap.get("properties");
		Map<String, Object> kakao_account = (Map<String, Object>) jsonMap.get("kakao_account");

		 System.out.println(properties.get("nickname"));
		 System.out.println(kakao_account.get("birthday"));
		 System.out.println(kakao_account.get("gender"));
		 System.out.println(properties.get("profile_image"));
		 System.out.println(properties.get("thumbnail_image"));
		 System.out.println(jsonMap.get("id"));

		String nickname = properties.get("nickname").toString();
		String birthday = kakao_account.get("birthday").toString();
		String gender = kakao_account.get("gender").toString();
		String profile_image = properties.get("profile_image").toString();
		String thumbnail_image = properties.get("thumbnail_image").toString();
		String id = jsonMap.get("id").toString();
		String isKaKao = "yes";
		
		
		userInfo.put("nickname", nickname);
		userInfo.put("birthday", birthday);
		userInfo.put("gender", gender);
		userInfo.put("profile_image", profile_image);
		userInfo.put("thumbnail_image", thumbnail_image);
		userInfo.put("id", id);
		userInfo.put("isKaKao", isKaKao);
		
		//해쉬,파일컴포넌트 변경해서 넘겨주기

	}catch(

	Exception e)
	{
		e.printStackTrace();
	}

	
	
	return userInfo;

}
	public void logout(String access_Token, String userid) {
	    String reqURL = "https://kapi.kakao.com/v1/user/unlink";
	    try {
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "Bearer" + access_Token);
//	        
//	        // 요청 본문 데이터 추가
//	        String data = "target_id_type=user_id&target_id="+userid;
//	        conn.setDoOutput(true);
//	        try (OutputStream os = conn.getOutputStream()) {
//	            byte[] input = data.getBytes("UTF-8");
//	            os.write(input, 0, input.length);
//	        }
	        
	        int responseCode = conn.getResponseCode();
	        System.out.println("responseCode : " + responseCode);
	        
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
