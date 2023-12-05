import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Optional;


public class OptionalTest01 {

    @Test
    public void test01() {
        String name = null;
        if (name == null) {     //null인 name에 값을 삽입
            name = "userA";
        }
        System.out.println(name.charAt(0)); //정상적으로 'u'가 출력된다.

    }

    @Test
    public void test02(){
        Optional<String> op = null;

        System.out.println("op = " + op);
        op = Optional.empty();
        System.out.println("op = " + op);
        System.out.println("op.isPresent() = " + op.isPresent());
    }

    @Test
    public void ofMethod(){
        String name = "userA";
        //of는 절대 값이 null이 아닐때 사용한다. Optional.of()로 null을 저정하려고 하면 NPE발생
        Optional<String> op = Optional.of(name);

        boolean result = new String("userA").equals(op.get()); //op에 담긴 값과 새로운 "userA"의 값이 같은지 확인
        System.out.println(result); //true 출력

    }



    @Test
    public void orElseAndElseGetMethod(){
        String name = "userA";
        String orElseResult = Optional.ofNullable(name).orElse(getName());

        System.out.println("orElseResult = " + orElseResult);

        String orElseGetResult = Optional.ofNullable(name).orElseGet(this::getName);

        System.out.println("orElseGetResult = " + orElseGetResult);
                
                
    }

    private String getName() {
        System.out.println("getName메서드 호출");
        return "userB";
    }





}
