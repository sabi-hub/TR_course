package com.telran.shape;

public class Picture extends Shape{
    Shape[] shapes;


    public Picture(Shape[] shapes) {
        this.shapes = shapes;
    }


    public void draw() {
        for (int i = 0; i <shapes.length ; i++) {
            shapes[i].draw();
        }
    }
}
