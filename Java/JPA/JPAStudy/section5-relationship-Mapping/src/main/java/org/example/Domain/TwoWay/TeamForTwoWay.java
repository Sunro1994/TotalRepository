package org.example.Domain.TwoWay;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class TeamForTwoWay {


    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    @Column(name = "name")
    private String username;

    //Arraylist로 초기화하는것을 관례로 많이 쓴다.
    @OneToMany(mappedBy = "team") // 1대 다 맵핑에서 team과 맵핑되어있다는 것을 명시
                                    // 가짜 매핑 - 주인의 반대편(Team.members)
    //해당 members를 변경하면 Team이 변경되는게 아닌 Member 테이블이 변경되게 된다.

    private List<MemberForTwoWay> members = new ArrayList<>();


}
