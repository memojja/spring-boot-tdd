package com.springboottdd.springboottdd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Telephone {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ddd;
    private String number;

}
