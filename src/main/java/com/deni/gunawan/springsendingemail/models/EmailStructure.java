package com.deni.gunawan.springsendingemail.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "email_structure")
public class EmailStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kepada; 
    private String cc;
    private String subject;
    private String body;
    private String attachments; 
}
