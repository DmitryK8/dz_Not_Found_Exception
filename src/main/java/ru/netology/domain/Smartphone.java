package ru.netology.domain;

public class Smartphone extends Product {
    private String production;

    public Smartphone(int id, String name, int price, String production) {
        super(id, name, price);
        this.production = production;
    }
}