package com.sunro.rest.webservices.restfulwebservices;

import org.assertj.core.api.Fail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyMathTest {

        MyMath math = new MyMath();
    @Test
    void calculate_ThreeMemberArray(){
        Assertions.assertEquals(math.caclulateSum(new int[]{1, 2, 3, 4, 5}), 15);
        //특정 동작에 대한 assert검사를 수행하게 된다.
    }

    @Test
    void test1(){
        Assertions.assertEquals(math.caclulateSum(new int[]{}), 0);
        //특정 동작에 대한 assert검사를 수행하게 된다.
    }
}
