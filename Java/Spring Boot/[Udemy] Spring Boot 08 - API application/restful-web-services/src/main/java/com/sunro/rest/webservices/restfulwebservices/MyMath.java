package com.sunro.rest.webservices.restfulwebservices;

public class MyMath {
    public int caclulateSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
