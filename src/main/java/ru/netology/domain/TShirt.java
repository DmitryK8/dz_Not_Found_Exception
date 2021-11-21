package ru.netology.domain;

public class TShirt extends Product {
    private String production;

    public TShirt(int id, String name, int price, String production) {
        super(id, name, price);
        this.production = production;

    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}