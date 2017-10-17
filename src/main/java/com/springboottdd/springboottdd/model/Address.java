package com.springboottdd.springboottdd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String publicPlace;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;

}
