package com.unicauca.smart_consumption.domain.model;

import java.util.List;

public class Store {
    private int id;
    private String nombre;
    private String direccion;
    private List<Product> productos;
    private List<Offer> ofertas;
    private City ubicacion;
}
