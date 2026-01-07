package com.lina.apirest.apirest.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/* Las entidades representan los objetos y  Encapsulan los datos y comportamientos
de esos objetos que luego van a ser mapeados con la base de datos.
Representan las tablas de la base de datos
*/

@Entity
public class Product {

    //Con las siguientes dos líneas se generará un id automáticamente y de manera incremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String name;
    private double price;

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}