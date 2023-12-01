package jpabook.jpashop.controller;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberForm {

    private String name;

    @NotEmpty(message = "회원 이름은 필수 입니다.") //값이 비어있으면 오류 메세지 출력
    private String city;
    private String street;
    private String zipcode;
}
