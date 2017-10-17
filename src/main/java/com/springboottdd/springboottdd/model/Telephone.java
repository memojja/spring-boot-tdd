package com.springboottdd.springboottdd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Telephone {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    private String ddd;
    private String number;


    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;


}
