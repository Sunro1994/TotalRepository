package org.example;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@DiscriminatorValue("A")
public class Album extends  Item{


    private String artist;

}
