package com.telran;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerProcessor implements Runnable {
    static final int INCOMING_DATAGRAM_SIZE = 1024;
    private DatagramSocket socket;

    public ServerProcessor(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while(true) {
            byte[] incomingData = new byte[INCOMING_DATAGRAM_SIZE];
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, INCOMING_DATAGRAM_SIZE);

            try {
                socket.receive(incomingPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String line = new String(incomingData, 0, incomingPacket.getLength());
            line = "Hello from UDP server " + line;

            DatagramPacket outgoingPacket = new DatagramPacket(line.getBytes()
                    , line.length()
                    , incomingPacket.getAddress()
                    , incomingPacket.getPort());

            try {
                socket.send(outgoingPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
