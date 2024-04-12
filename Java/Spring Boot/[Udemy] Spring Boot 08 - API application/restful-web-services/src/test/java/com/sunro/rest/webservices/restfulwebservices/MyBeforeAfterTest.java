package com.sunro.rest.webservices.restfulwebservices;

import org.junit.jupiter.api.*;

public class MyBeforeAfterTest {

    //뭔가 하기전 전체적으로 적용하고 싶은게 있다면  BeforeAll을 사용
    //메서드는 반드시 정적 타입이여야 한다.
    @BeforeAll
    static void beforeAll(){
        System.out.println("beforeAll");
    }

    //테스트 순서를 보장할 수 없다.
    //만약 각 테스트 전에 뭔가 하고 싶다면 BeforeEach를 사용
    // 후에 뭔가 하고 싶다면 AfterEach를 사용

    @BeforeEach
    void beforeEach(){
        System.out.println("BeforeEach");
    }

    @AfterEach
    void afterEach(){
        System.out.println("AfterEach");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("AfterAll");
    }



    @Test
    void test1(){
        System.out.println("test1");
    }
    @Test
    void test2(){
        System.out.println("test2");
    }
    @Test
    void test3(){
        System.out.println("test3");
    }
}
