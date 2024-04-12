package com.sunro.rest.webservices.restfulwebservices.business;

import com.sunro.rest.webservices.restfulwebservices.mocktodemo.business.DataService;
import com.sunro.rest.webservices.restfulwebservices.mocktodemo.business.SomeBusinessImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

//Mockto를 사용하기 위한 확장이 필요하다. ExtendWith어노테이션 사용
@ExtendWith(MockitoExtension.class)
public class SomeBusinessImlMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    void findTheGratestAllData_basicScenario(){
        //필요한경우 만들어서 사용가능하다.
        when(dataServiceMock.retrieveAllDate()).thenReturn(new int[]{25, 5, 15});
        Assertions.assertEquals(25, businessImpl.findTheGreatesFromAllData());
    }
}


