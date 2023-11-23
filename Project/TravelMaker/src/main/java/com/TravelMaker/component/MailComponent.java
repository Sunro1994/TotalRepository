package com.TravelMaker.component;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

@Component
public class MailComponent {

    private final String host = "smtp.naver.com";

    private final int port = 465;
    private String serverId = "hwangminu0";   // 메일 계정
    private String serverPw = "'1q2w3e4r1@";   // 메일 계정 비밀번호

    private Properties props;

    // classPath 에서 특정 파일 불러오기
    // src/main/java
    // src/main/resources
    @Value("classpath:mailForm.html")
    private Resource mailForm;
    
    /* 생성자 */
    public MailComponent(){

        props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", host);
    }
    
    /* 메일 전송 메서드  */
    public int sendMimeMessage(HashMap<String, String> param) {
        Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
            String un = serverId;
            String pw = serverPw;

            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(un, pw);
            }
        });
        mailSession.setDebug(true);     // 메일 발송 시 진행 상황을 콘솔에 출력
                                        // 테스트 할때만 사용하고 지우기
        Message message = new MimeMessage(mailSession);
        String tag = "";

        try {
            Scanner sc = new Scanner(mailForm.getFile());
            while(sc.hasNextLine()){
                tag += sc.nextLine();
            }
            sc.close();

            message.setFrom(new InternetAddress(serverId + "@naver.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(param.get("receiver")));
            message.setSubject(param.get("subject"));
            message.setContent(
                    String.format(tag, param.get("content")),
                                "text/html; charset=utf-8");
            Transport.send(message);
            return 1;

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            return 0;
        }

    }




}
