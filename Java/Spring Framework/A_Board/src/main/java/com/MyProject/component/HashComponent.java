package com.MyProject.component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class HashComponent {
	
	public String getSalt() {
		String salt = null;
		//보안 가능한 수준의 랜덤함수
		SecureRandom ran = new SecureRandom();
		//16자리의 배열을 만든다.
		byte[] arr = new byte[16];
		//배열안에 랜덤한 바이트의 수를 집어 넣는다.
		ran.nextBytes(arr);
		salt = new String(Base64.getEncoder().encode(arr));
		
		return salt;
	}
	
	public String getHaSh(String source, String salt) {
		//결과를 받을 hash문자열
		String hash = null;
		//암호화를 수행할 md객체
		MessageDigest md = null;
		
		try {
			// SHA-512와 일치하는 객체를 생성
			md = MessageDigest.getInstance("SHA-512");
			//salt의 바이트 값을 입력하여 생성
			md.update(salt.getBytes());
			// source의 바이트 값을 입력하여 생성
			md.update(source.getBytes());
			//최종적으로 md.digest를 수행한 BigInteger 타입의 문자를 16진수 타입으로 포맷하여 생성
			hash = String.format("%0128X", new BigInteger(1,md.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} //해쉬 알고리즘 : SHA-512
	
		return hash;
	}
	

}
