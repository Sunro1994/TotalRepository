package com.sunro.rest.webservices.restfulwebservices.business;

import com.sunro.rest.webservices.restfulwebservices.mocktodemo.business.DataService;
import com.sunro.rest.webservices.restfulwebservices.mocktodemo.business.SomeBusinessImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SomeBusinessImlTest {

    @Test
    void findTheGratestAllData_basicScenario(){
        DataService dataServiceStub = new DataServiceStub();

        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int result = business.findTheGreatesFromAllData();
        Assertions.assertEquals(25,result);
    }
}


//stub을 만들면 새로운 시나리오를 만들때마다 그에 맞는 데이터가 필요하다.
class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllDate() {
        return new int[]{25,15,5};
    }
}
