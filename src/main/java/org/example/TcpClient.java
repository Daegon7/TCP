package org.example;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpClient {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 5000;

        String one = "a".repeat(100);
        String two = "b".repeat(20);
        String three = "c".repeat(8);

        String message = one + two + three;

        try (Socket socket = new Socket(host, port)) {
            OutputStream out = socket.getOutputStream();
            out.write(message.getBytes(StandardCharsets.UTF_8));
            out.flush();
        }
    }
}