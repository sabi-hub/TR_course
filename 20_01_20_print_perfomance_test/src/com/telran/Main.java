package com.telran;

import com.telran.printer.PrintStreamPrinter;
import com.telran.printer.PrintWriterPrinter;
import com.telran.printer.PrinterInterface;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        PrinterInterface printStream = new PrintStreamPrinter(new PrintStream(new FileOutputStream("print_stream.txt")));

        PrinterInterface printWriter = new PrintWriterPrinter((new PrintWriter("print_writer.txt")));

        PrinterPerformanceTesting ppt = new PrinterPerformanceTesting(printStream);
        System.out.println("Result for PrintStream is:");
        System.out.println(ppt.testNLines(10000, "Hello"));

        ppt=new PrinterPerformanceTesting(printWriter);
        System.out.println("Result for PrintWriter is:");
        System.out.println(ppt.testNLines(10000, "Hello"));
    }

}
