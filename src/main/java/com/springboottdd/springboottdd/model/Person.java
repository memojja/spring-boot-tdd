package com.springboottdd.springboottdd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
//    private String cpf;
    private List<Address> addresses;
    private List<Telephone> telephones;
}
