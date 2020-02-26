package com.telran;

public class Application {

    public static void main(String[] args) {
        Messenger messenger = new Messenger("lines.txt");

        Thread sender = new Sender(messenger);

        Thread[]receivers = new Thread[5];
        for (int i = 0; i < receivers.length ; i++) {
            receivers[i] = new Receiver(messenger);
            receivers[i].setDaemon(true);
        }

        for (int i = 0; i < receivers.length ; i++) {
            receivers[i].start();
        }

        sender.start();

    }
}
