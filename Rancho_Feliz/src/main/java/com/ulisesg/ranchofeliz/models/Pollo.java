package com.ulisesg.ranchofeliz.models;

public class Pollo extends Animal {

    private String huevos;

    public Pollo(String identidicador, String tipo, String sexo, String huevos) {
        super(identidicador, tipo, sexo);
        this.huevos = huevos;
    }

    @Override
    public String toString() {
        return "Pollo{" +
                "huevos='" + huevos + '\'' +
                ", identidicador='" + identidicador + '\'' +
                ", tipo='" + tipo + '\'' +
                ", raza='" + raza + '\'' +
                '}';
    }
}
