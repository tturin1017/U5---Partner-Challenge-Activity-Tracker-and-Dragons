package com.example.project;
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
        System.out.println(dragon.state());
   }
}
