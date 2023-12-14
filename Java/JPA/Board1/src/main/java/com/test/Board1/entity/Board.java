package com.test.Board1.entity;

import com.test.Board1.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@ToString(of = {"title","content","wdate"})
public class Board extends BaseEntity {

    public Board(Member member, String title, String content) {
        this.member = member;
        this.title = title;
        this.content = content;
        this.wdate = LocalDateTime.now();
        this.setWriter(member.getUserId());
    }

    public void setmodifiedDate(){
        this.setModfied_date(LocalDateTime.now());
        this.setModifier(member.getUserId());
    }

    @Id
    @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member;

    @Column(name = "board_title")
    private String title;

    @Column(name = "board_content")
    private String content;

    @Column(name = "board_wdate")
    private LocalDateTime wdate;

}
