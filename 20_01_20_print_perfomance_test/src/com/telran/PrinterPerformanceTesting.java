package com.telran;

import com.telran.printer.PrinterInterface;

public class PrinterPerformanceTesting {

    PrinterInterface pi;

    public PrinterPerformanceTesting(PrinterInterface pi){
        this.pi = pi;
    }

    public long testNLines(int n, String line){

        long now = System.currentTimeMillis();
        for (int i = 0; i <n ; i++) {
            pi.println(line);
        }
        pi.close();
        return System.currentTimeMillis()-now;

    }

}
