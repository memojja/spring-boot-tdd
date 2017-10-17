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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String publicPlace;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;


    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
