package com.example.project;
import java.util.Scanner;

public class Main {
    
   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       System.out.print("Enter your goal in minutes: ");
       int goal = scan.nextInt();

       // create an ActivityTracker object
       ActivityTracker tracker = new ActivityTracker(goal);

       // loop until the user has logged enough minutes to reach their goal,
       // allowing them to enter a new activity each time and printing out
       // the stats after each
       while (!tracker.goalAchieved()) {
           System.out.print("Enter the number of minutes for your activity session: ");
           int minutes = scan.nextInt();
           tracker.logMinutes(minutes);
           System.out.println("---- Current Stats ----");
           System.out.println("Number of sessions: " + tracker.getSessions());
           System.out.println("Total number of minutes: " + tracker.getTotalMinutes());
           System.out.println("Longest session logged (max minutes): " + tracker.getMaxMinutes());
           System.out.println("You reached your goal: " + tracker.goalAchieved());
           System.out.println("-----------------------");
       }

       System.out.println("Thank you for using the activity tracker!");
   }
}
