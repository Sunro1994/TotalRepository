package org.example;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Album extends Item{


    private String artist;
    private String etc;

}
