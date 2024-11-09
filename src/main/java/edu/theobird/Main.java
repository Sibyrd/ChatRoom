package edu.theobird;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello world!");
        Interface UI = new Interface();
        WebsocketClient.connect();

        MessageManager.createMessage("Welcome to the chat room - the first message you send will be your username. Every message afterwards will send normally.");
    }
}