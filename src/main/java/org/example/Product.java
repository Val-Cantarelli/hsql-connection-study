package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // sinaliza ao Hibernate que cada objeto é uma linha numa tabela do DB
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Product(){}

    public Product(String name){
        this.name = name;
    }

    public Long getId(){return id;}
    public String getName(){return name;}

    public void setName(String name) {
        this.name = name;
    }
}
