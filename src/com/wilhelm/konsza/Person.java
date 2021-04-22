package com.wilhelm.konsza;

public class Person {
    private String name;
    private int age;
    private Gender gender;
    private Species species;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.species = Species.HUMAN;
    }

    public Person(String name, int age, Species species) {
        this.name = name;
        this.age = age;
        this.gender = Gender.UNKNOWN;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Species getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", species=" + species +
                '}';
    }
}
