package com.telran;

import com.telran.shape.Line;
import com.telran.shape.Picture;
import com.telran.shape.Rectangle;
import com.telran.shape.Shape;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
	// write your code here
        Line line = new Line('*', 10);
        Rectangle rectangle = new Rectangle('*', 4,3);

        Shape[]shapes = {line, rectangle};

        Picture picture = new Picture(shapes);
        picture.draw();






    }
}
