package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        FileRowRotater rotater = new FileRowRotater("src/main/resources/input3.txt");

        rotater.rotateRows();
    }
}