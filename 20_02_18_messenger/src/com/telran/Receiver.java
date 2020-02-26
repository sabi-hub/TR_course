package com.telran;

public class Receiver extends Thread {

    Messenger messenger;

    public Receiver(Messenger messenger) {
        this.messenger = messenger;
    }

    @Override
    public void run() {

        while (true) {
            try {
                String message = messenger.removeMessage();
                System.out.println(message+" "+ getName());
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
