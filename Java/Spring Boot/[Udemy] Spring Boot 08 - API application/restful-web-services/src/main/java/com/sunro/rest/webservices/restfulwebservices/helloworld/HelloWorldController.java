package com.sunro.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
public class HelloWorldController {
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World v2";
    }
    @GetMapping(path = "/basicauth")
    public String basicAuthCheck(){
        return "Success";
    }

    @GetMapping(path = "/hello-world-bean")
    public HellowWorldBean helloWorldBean(){
        return new HellowWorldBean("Hellow WorldBean");
    }

    //Path Parameters
    // /users/{id}/todos/{id}
//    {id} 이러한 부분들을 패스 매개변수라고 한다.
    // /hello-world/path-vbariable/{name}

    @GetMapping(path = "/hello-world/path-variable/{name}") //{name}과 변수명이 동일해야한다.
    public HellowWorldBean hellowWorldPathVaribale(@PathVariable(value = "name")String name){
        return new HellowWorldBean(String.format("Hellow World , %s",name));
    }
}
