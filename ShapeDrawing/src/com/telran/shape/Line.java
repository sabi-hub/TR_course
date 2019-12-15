package com.telran.shape;

public class Line extends Shape {
    public Line(char symbol, int length) {
        super(symbol);
        this.length = length;
    }

    int length;

    void draw() {
        for (int i = 0; i <length ; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

}
