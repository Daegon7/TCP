package org.example;

import java.io.*;
import java.net.*;
import java.util.Properties;

public class TcpServer {
    public static void main(String[] args) {
        int port = 5000;

        int lenOne = 0, lenTwo = 0, lenThree = 0;

        // Load byte lengths from config.properties
        try (InputStream input = TcpServer.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.err.println("config.properties not found in classpath.");
                return;
            }
            Properties prop = new Properties();
            prop.load(input);
            lenOne = Integer.parseInt(prop.getProperty("one"));
            lenTwo = Integer.parseInt(prop.getProperty("two"));
            lenThree = Integer.parseInt(prop.getProperty("three"));
        } catch (IOException | NumberFormatException e) {
            System.err.println("Failed to load or parse config.properties");
            e.printStackTrace();
            return;
        }

        int totalLength = lenOne + lenTwo + lenThree;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                InputStream in = clientSocket.getInputStream();
                byte[] buffer = new byte[totalLength];
                int bytesRead = in.read(buffer);

                if (bytesRead == totalLength) {
                    String received = new String(buffer, "UTF-8");
                    System.out.println("Raw received: " + received);

                    String partOne = received.substring(0, lenOne);
                    String partTwo = received.substring(lenOne, lenOne + lenTwo);
                    String partThree = received.substring(lenOne + lenTwo, totalLength);

                    System.out.println("one   : " + partOne);
                    System.out.println("two   : " + partTwo);
                    System.out.println("three : " + partThree);
                } else {
                    System.out.println("Expected " + totalLength + " bytes, but received " + bytesRead);
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}