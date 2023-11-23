package org.example;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Locker {

    @Id@GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker") //읽기 전용 맵핑
    private Member member;
}
