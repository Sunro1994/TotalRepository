package com.sunro.rest.webservices.restfulwebservices.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class ListTest {

    @Test
    void simpleTest(){

        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(3);

        Assertions.assertEquals(3, listMock.size());
    }

    @Test
    void multipleReturns(){
        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(1).thenReturn(2);

        Assertions.assertEquals(1, listMock.size());
        Assertions.assertEquals(2, listMock.size());
    }
    @Test
    void ParamtersReturns(){
        List listMock = mock(List.class);

        //anyInt를 설정하면 어떤수를 매개변수로 넣든간에 동일하게 "SomeString"을 반환하도록 한다.
        when(listMock.get(anyInt())).thenReturn("SomeString");

        Assertions.assertEquals("SomeString", listMock.get(0));
        Assertions.assertEquals("SomeString", listMock.get(1));
    }
}
