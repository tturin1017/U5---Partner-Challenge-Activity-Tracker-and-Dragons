package com.example.project;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
     Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();
        

        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        System.setOut(ps);
        dragon.takeDamage(70);
        ps.flush();
        System.setOut(originalOut);
        System.out.println("---"+bos.toString());
        
   }
}
