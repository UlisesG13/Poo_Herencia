package com.ulisesg.ranchofeliz.controllers;
import com.ulisesg.ranchofeliz.models.Animal;
import com.ulisesg.ranchofeliz.models.Pollo;
import com.ulisesg.ranchofeliz.models.Rancho;
import com.ulisesg.ranchofeliz.models.Vaca;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

public class MenuController {

    private Rancho rancho = new Rancho();

    @FXML
    private TextArea texto;


    @FXML
    void agregarlote(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Agregar Datos");
        dialog.setHeaderText("Agregre identificador de animal");
        Optional<String> identificator = dialog.showAndWait();
        dialog.setHeaderText("Agregre raza del animal");
        Optional<String> raza = dialog.showAndWait();
        var ref = new Object() {
            boolean escritoCorrectamente = false;
        };
        do {
            dialog.setHeaderText(" Tipo de animal (Vaca, Pollo) ");
            Optional<String> tipo = dialog.showAndWait();
            tipo.ifPresent(respuesta->{
                if (respuesta.equalsIgnoreCase("Pollo")){
                    dialog.setHeaderText(" agregue cantidad de huevos");
                    Optional<String> huevo = dialog.showAndWait();
                    huevo.ifPresent(huevos -> {
                        Animal pollo=new Pollo(identificator.orElse(""), tipo.orElse(""), raza.orElse(""), huevos);
                        rancho.addAnimales(pollo);
                        texto.setText(rancho.animales());
                    });
                    ref.escritoCorrectamente = true;
                }
                if (respuesta.equalsIgnoreCase("Vaca")){
                    dialog.setHeaderText(" litros de leche ordeñados");
                    Optional<String> leche = dialog.showAndWait();
                    leche.ifPresent(leches -> {
                        Animal vaca=new Vaca(identificator.orElse(""), tipo.orElse(""), raza.orElse(""), leches);
                        rancho.addAnimales(vaca);
                        texto.setText(rancho.animales());
                    });
                    ref.escritoCorrectamente = true;
                }
            });
        } while (!ref.escritoCorrectamente);
    }

    @FXML
    void cancelarlote(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Eliminar lote");
        dialog.setHeaderText("Ingrese el identificador del animal a eliminar");
        Optional<String> respuesta = dialog.showAndWait();
        respuesta.ifPresent(identificador-> {
            int iteradorEliminar = -1;
            boolean iterar = true;
            for (int i = 0; i < rancho.getAnimalList().size() && iterar; i++) {
                if (rancho.getAnimalList().get(i).getIdentidicador().equals(identificador)) {
                    iteradorEliminar = i;
                    iterar = false;
                }
            }
            if (iteradorEliminar != -1) {
                rancho.getAnimalList().remove(iteradorEliminar);
            }
            texto.setText(rancho.animales());
        });
    }

    @FXML
    void editarlote(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Editar informacion nueva del lote");
        dialog.setHeaderText("Ingrese el identificador del animal");
        Optional<String> respuesta = dialog.showAndWait();
        respuesta.ifPresent(identificador-> {
            int iteradorEditar = 0;
            boolean animalEncontrado = false;
            for (int iterador = 0; iterador < rancho.getAnimalList().size(); iterador++) {
                if (identificador.equals(rancho.getAnimalList().get(iterador).getIdentidicador())) {
                    iteradorEditar = iterador;
                    animalEncontrado = true;
                }
            }
            if (animalEncontrado) {
                dialog.setTitle("Agregar");
                dialog.setHeaderText("Agregre identificador de animal");
                Optional<String> identificator = dialog.showAndWait();
                dialog.setHeaderText("Agregre raza del animal");
                Optional<String> raza = dialog.showAndWait();
                var ref = new Object() {
                    boolean escritoCorrectamente = true;
                };
                do {
                    dialog.setHeaderText(" Tipo de animal (Vaca, Pollo) ");
                    Optional<String> tipo = dialog.showAndWait();
                    int finalIteradorEditar = iteradorEditar;
                    int finalIteradorEditar1 = iteradorEditar;
                    tipo.ifPresent(resp->{
                        if (resp.equalsIgnoreCase("Pollo")){
                            dialog.setHeaderText(" agregue cantidad huevos");
                            Optional<String> huevo = dialog.showAndWait();
                            huevo.ifPresent(huevos -> {
                                Animal pollo=new Pollo(identificator.orElse(""), tipo.orElse(""), raza.orElse(""), huevos);
                                rancho.getAnimalList().set(finalIteradorEditar, pollo);
                                texto.setText(rancho.animales());
                            });
                            ref.escritoCorrectamente = false;
                        }
                        if (resp.equalsIgnoreCase("Vaca")){
                            dialog.setHeaderText(" litros de leche ordeñados");
                            Optional<String> leche = dialog.showAndWait();
                            leche.ifPresent(leches -> {
                                Animal vaca=new Vaca(identificator.orElse(""), tipo.orElse(""), raza.orElse(""), leches);
                                rancho.getAnimalList().set(finalIteradorEditar1, vaca);
                                texto.setText(rancho.animales());

                            });
                            ref.escritoCorrectamente = false;
                        }
                    });
                } while (ref.escritoCorrectamente);
                texto.setText(rancho.animales());
            }
        });
    }


}

