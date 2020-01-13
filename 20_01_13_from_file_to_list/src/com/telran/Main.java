package com.telran;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        FileOperations fo =new FileOperations();
        fo.stringToInts("int.txt");


        System.out.println(fo.stringToInts("int.txt"));



    }
}
