package com.telran.shape;

public class Picture extends Shape{
    Shape[] shapes;


    public Picture(Shape[] shapes) {
        this.shapes = shapes;
    }


    public Shape[] getShapes() {
        for (int i = 0; i <shapes.length ; i++) {
            shapes[i].draw();
        }
        return shapes;
    }

    @Override
    void draw() {

    }
}
