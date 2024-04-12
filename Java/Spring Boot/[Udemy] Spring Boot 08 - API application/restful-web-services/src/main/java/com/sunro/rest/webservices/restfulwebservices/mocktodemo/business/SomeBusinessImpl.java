package com.sunro.rest.webservices.restfulwebservices.mocktodemo.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SomeBusinessImpl {

    private DataService dataService;

    public int findTheGreatesFromAllData(){
        int[] ints = dataService.retrieveAllDate();
        int greatestValue = Integer.MIN_VALUE;
        for (int value : ints) {
            if (value > greatestValue) {
                greatestValue = value;
            }
        }
        return greatestValue;
    }

}
