package com.telran;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerProcessor implements Runnable {
    static final int INCOMING_DATAGRAM_SIZE = 1024;
    private DatagramSocket socket;
    private DatagramPacket incomingPacket;
    byte[] incomingData;

    public ServerProcessor(DatagramSocket socket, DatagramPacket incomingPacket, byte[] incomingData) {
        this.socket = socket;
        this.incomingPacket = incomingPacket;
        this.incomingData = incomingData;
    }

    @Override
    public void run() {
        try {

            String line = new String(incomingData, 0, incomingPacket.getLength());
            line = "Hello from UDP server " + line;

            DatagramPacket outgoingPacket = new DatagramPacket(line.getBytes(), line.length()
                    , incomingPacket.getAddress(), incomingPacket.getPort());

            socket.send(outgoingPacket);
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
