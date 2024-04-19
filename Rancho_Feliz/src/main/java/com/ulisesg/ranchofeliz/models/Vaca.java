package com.ulisesg.ranchofeliz.models;

public class Vaca extends Animal {
    private String leche;

    public Vaca(String identidicador, String tipo, String raza, String leche) {
        super(identidicador, tipo, raza);
        this.leche = leche;
    }

    @Override
    public String toString() {
        return "Vaca{" +
                "leche='" + leche + '\'' +
                ", identidicador='" + identidicador + '\'' +
                ", tipo='" + tipo + '\'' +
                ", raza='" + raza + '\'' +
                '}';
    }
}
