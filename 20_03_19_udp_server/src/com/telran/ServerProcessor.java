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
//            byte[] incomingData = new byte[INCOMING_DATAGRAM_SIZE];
//            DatagramPacket incomingPacket = new DatagramPacket(incomingData, INCOMING_DATAGRAM_SIZE);//входящие пакеты
//            socket.receive(incomingPacket);

            //откуда данные, с какого индекса (0), размер от пакета (сколько в итоге пришло байт)
            String line = new String(incomingData, 0, incomingPacket.getLength());
            line = "Hello from UDP server " + line;

            //отпркавка сообщения обратно
            DatagramPacket outgoingPacket = new DatagramPacket(line.getBytes(), line.length()
                    , incomingPacket.getAddress(), incomingPacket.getPort());

            socket.send(outgoingPacket);
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
