package com.springboottdd.springboottdd.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String tc;
    @OneToMany
    private List<Address> addresses;
    @OneToMany
    private List<Telephone> telephones;
}
