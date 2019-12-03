package com.telran.shape;

public class Rectangle extends Shape{
    int width;
    int height;

    public Rectangle(char symbol, int width, int height) {
        super(symbol);
        this.width = width;
        this.height = height;
    }


    void draw() {
        //filled rectangle (var.A)
        for (int i = 0; i <height ; i++) {
            System.out.println();
            for (int j = 0; j <width ; j++) {
                System.out.print(symbol+" ");
            }
        }
        System.out.println();
        System.out.println();

        //hollow rectangle (var.B*)
        for (int i = 0; i <width ; i++) {
            System.out.print(symbol);
        }

        System.out.println();

        for (int i = 0; i <height-2 ; i++) {
            System.out.print(symbol);
            for (int j = 0; j <width - 2 ; j++) {
                System.out.print(" ");
            }
            System.out.println(symbol);
        }

        for (int i = 0; i <width ; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
