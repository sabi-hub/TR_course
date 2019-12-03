package com.telran.shape;

public abstract class Shape {
    public Shape(char symbol) {
        this.symbol = symbol;
    }

    char symbol;

    protected Shape() {
    }

    abstract void draw();
}
