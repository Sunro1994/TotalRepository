package org.example.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;


    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members;

}
