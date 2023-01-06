package org.example;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");
        FileRowRotater rotater = new FileRowRotater("src/main/resources/input3.txt");

        rotater.rotateRows();
    }
}