package com.telran;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Messenger {

    private final Object mu = new Object();
    String outputFilename;

    public Messenger(String outputFilename) {
        this.outputFilename = outputFilename;
    }

    private volatile String message;//volatile переменные которые нигде промежуточно не записываются и не сохраняются, без кэш

    public void addMessage(String message) {
        synchronized (mu){
            this.message = message;
            mu.notifyAll();
        }
    }

    public String removeMessage() throws InterruptedException {
        synchronized (mu){
            while (message==null)
                mu.wait();

            String res = message;
            message = null;
            return res;
        }
    }

    public void listToFile(List<String> content) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(outputFilename)){
            for (String line: content) {
                pw.println(line);
            }
        }
    }
}
