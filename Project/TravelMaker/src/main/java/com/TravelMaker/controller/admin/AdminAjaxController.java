package com.TravelMaker.controller.admin;

import com.TravelMaker.component.HashComponent;
import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
@RequestMapping("/ajax")
public class AdminAjaxController {

    @Autowired private HashComponent hashcomponent;


    @PostMapping("/adminCheck")
    public String adminCheck(@RequestBody String password, HttpSession session){
        TravelMaker_MemberDTO curUser = (TravelMaker_MemberDTO) session.getAttribute("user");
        String salt = curUser.getTravelMaker_Member_Salt();
        password =  password.replace("password=", "");

        /**
         * @author 선로
         *
         * 특수문자가 올경우 디코딩을 통해 올바른 특수문자를 전달받게 함
         */
        try {
            password = URLDecoder.decode(password, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(password);

        String response = hashcomponent.getHash(password, salt);
        return  response;
    }


}