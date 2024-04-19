package com.ulisesg.ranchofeliz.models;
import java.util.ArrayList;

public class Rancho {
    private ArrayList<Animal> animalList = new ArrayList<Animal>();
    Animal animal = new Animal();

    public void addAnimales(Animal animal){
        animalList.add(animal);
    }

    public String animales(){
        String animales = "";
        for (Animal animal: animalList){
            animales = animales + animal.toString() + "\n";
        }
        return animales;
    }

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }
}
