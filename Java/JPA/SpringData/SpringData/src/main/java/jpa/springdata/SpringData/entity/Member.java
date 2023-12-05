package jpa.springdata.SpringData.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Member {

    @Id @GeneratedValue
    private  Long id;
    private  String username;

    public Member(String memberA) {
        this.username = memberA;
    }

    //생성자는 protected까지의 접근제한자를 둔다. 왜냐하면 프록시객체를 생성할때  접근하기 위함
    public Member() {

    }
}
