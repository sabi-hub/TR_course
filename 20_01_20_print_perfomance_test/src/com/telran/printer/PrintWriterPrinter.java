package com.telran.printer;

import java.io.PrintWriter;

public class PrintWriterPrinter implements PrinterInterface {

    PrintWriter pw;

    public PrintWriterPrinter(PrintWriter pw){
        this.pw = pw;
    }

    @Override
    public void println(String line) {
        pw.println(line);
    }

    @Override
    public void close() {
        pw.close();
    }
}
