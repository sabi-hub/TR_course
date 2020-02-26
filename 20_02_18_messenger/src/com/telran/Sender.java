package com.telran;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Sender extends Thread {

    Messenger messenger;
    List<String> lines = new ArrayList<>();

    public Sender(Messenger messenger) {
        this.messenger = messenger;
    }

    @Override
    public void run() {
        try(BufferedReader isr = new BufferedReader(new InputStreamReader(System.in))){
            String line;

            while ((line = isr.readLine())!=null&&!line.equals("exit")){
                messenger.addMessage(line);
                lines.add(line);
//                System.out.println(lines);
            }
            messenger.listToFile(lines);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
