package com.springboottdd.springboottdd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String tc;

    @OneToMany(mappedBy ="person",cascade = CascadeType.REMOVE)
    private List<Address> addresses;

    @OneToMany(mappedBy ="person",cascade = CascadeType.REMOVE)
    private List<Telephone> telephones;
}
