package com.telran;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileOperations {
    public List<Integer> stringToInts(String filename) throws IOException {

        String[] temp;
        List<Integer> myList = new ArrayList<>();
        String delimiter = " ";
        String str = new String(bytesFromFile(filename));
//        System.out.println(str);
        temp = str.split(delimiter);
//        for (int i = 0; i < temp.length; i++) {
//            System.out.println(temp[i]);
//        }
//
        for (int i = 0; i < temp.length; i++) {
            myList.add(Integer.parseInt(temp[i]));
        }
        return myList;

    }

    public byte[] bytesFromFile(String filename) throws IOException {

        FileInputStream fis = new FileInputStream(filename);
        int length = fis.available();
        byte[] bytes = new byte[length];
        try {
            fis.read(bytes);
        } finally {
            fis.close();
        }
        return bytes;
    }


}
