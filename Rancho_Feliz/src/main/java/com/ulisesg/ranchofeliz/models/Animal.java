package com.ulisesg.ranchofeliz.models;

public class Animal {

    protected String identidicador;
    protected String tipo;
    protected String raza;

    public String getIdentidicador() {
        return identidicador;
    }

    public Animal() {
    }

    public Animal(String identidicador, String tipo, String raza) {
        this.identidicador = identidicador;
        this.tipo = tipo;
        this.raza = raza;
    }

}
