package src;

import java.util.Random;

public class Pet {
    protected String name;
    protected double weight;
    protected int age;
    protected String owner;

    public Pet(String name, double weight, int age, String owner) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.owner = owner;
    }

    public void say() {
        System.out.println("some sound");
    }

    enum FoodType {
        CHEAP, EXPENSIVE
    }

    public static class Cat extends Pet {
        private String breed;
        private FoodType foodType;

        public Cat(String name, double weight, int age, String owner, String breed, FoodType foodType) {
            super(name, weight, age, owner);
            this.breed = breed;
            this.foodType = foodType;
        }

        @Override
        public void say() {
            System.out.println("Мяу!");
        }

        public void walk(String name) {
            System.out.println(this.name + " is walking with " + name);
        }
    }

    public static class Dog extends Pet {
        private String breed;
        private FoodType foodType;

        public Dog(String name, double weight, int age, String owner, String breed, FoodType foodType) {
            super(name, weight, age, owner);
            this.breed = breed;
            this.foodType = foodType;
        }

        @Override
        public void say() {
            System.out.println("Гав!");
        }

        public void walk(String name) {
            System.out.println(this.name + " is walking with " + name);
        }
    }

    public static class Parrot extends Pet {
        private String country;
        private boolean hasDocuments;

        public Parrot(String name, double weight, int age, String owner, String country, boolean hasDocuments) {
            super(name, weight, age, owner);
            this.country = country;
            this.hasDocuments = hasDocuments;
        }

        @Override
        public void say() {
            System.out.println("parrrrrrot");
        }
    }
}
