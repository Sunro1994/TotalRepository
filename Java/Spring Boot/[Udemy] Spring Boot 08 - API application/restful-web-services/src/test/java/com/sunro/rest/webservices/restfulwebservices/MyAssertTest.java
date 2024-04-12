package com.sunro.rest.webservices.restfulwebservices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {
    List<String> todos = Arrays.asList("Java", "Azure", "DevOps");

    @Test
    void test(){
        boolean test = todos.contains("Java");
        boolean test2 = todos.contains("Java17");
        assertEquals(true,test);
        assertEquals(3,todos.size(),"Error Message");
        assertTrue(test,"Something went wroong");
        assertFalse(test2);
        assertArrayEquals(new int[]{1,2}, new int[] {1,3});

    }
}
