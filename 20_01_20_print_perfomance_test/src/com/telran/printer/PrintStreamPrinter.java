package com.telran.printer;

import java.io.PrintStream;

public class PrintStreamPrinter implements PrinterInterface {

    PrintStream ps;

    public PrintStreamPrinter(PrintStream ps) {
        this.ps = ps;
    }

    @Override
    public void println(String line) {
        ps.println(line);

    }

    @Override
    public void close() {
        ps.close();
    }
}
