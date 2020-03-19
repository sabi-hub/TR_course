package com.telran;

import javax.print.attribute.standard.RequestingUserName;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static final int INCOMING_DATAGRAM_SIZE = 1024;
    static final int PORT = 3000;

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(PORT);

        //Multithreading
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ServerProcessor sp = new ServerProcessor(socket);
        executor.execute(sp);


        //udp server without multithreading
//        while (true) {
//            byte[] incomingData = new byte[INCOMING_DATAGRAM_SIZE];//максимальный размер, какой может быть
//            // куда записать и размер пакеты
//            DatagramPacket incomingPacket = new DatagramPacket(incomingData, INCOMING_DATAGRAM_SIZE);//входящие пакеты
//            socket.receive(incomingPacket);
//
////            //откуда данные, с какого индекса (0), размер от пакета (сколько в итоге пришло байт)
//            String line = new String(sp.incomingData, 0,sp.incomingPacket.getLength());
//            line = "Hello from UDP server " + line;
//
//            //отпркавка сообщения обратно
//
//            DatagramPacket outgoingPacket = new DatagramPacket(line.getBytes(), line.length()
//                    ,sp.incomingPacket.getAddress(), sp.incomingPacket.getPort());
//            socket.send(outgoingPacket);
//        }

    }
}
