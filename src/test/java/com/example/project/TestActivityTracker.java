package com.example.project;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.beans.Transient;
import java.io.*;

public class TestActivityTracker {

   @Test
    public void testRow1(){
        ActivityTracker tracker = new ActivityTracker(120);
        int expectedOutput = 120;
        int studentOutput = tracker.getTargetGoal();
        assertEquals(expectedOutput,studentOutput);
    }

    @Test
    public void testRow2(){
        ActivityTracker tracker = new ActivityTracker(120);
        int expectedOutput = 0;
        int studentOutput = tracker.getTotalMinutes();
        assertEquals(expectedOutput,studentOutput);
    }

    @Test
    public void testRow4(){
        ActivityTracker tracker = new ActivityTracker(120);
        int expectedOutput = 0;
        int studentOutput = tracker.getSessions();
        assertEquals(expectedOutput,studentOutput);
    }

    @Test
    public void testRow6(){
        ActivityTracker tracker = new ActivityTracker(120);
        int expectedOutput = 0;
        int studentOutput = tracker.getMaxMinutes();
        assertEquals(expectedOutput,studentOutput);
    }

    @Test
    public void testRow8(){
        ActivityTracker tracker = new ActivityTracker(120);
        boolean expectedOutput = false;
        boolean studentOutput = tracker.goalAchieved();
        assertEquals(expectedOutput,studentOutput);
    }

    @Test //confirms logMInutes is void
    public void testRow10(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        ActivityTracker tracker = new ActivityTracker(120);
        tracker.logMinutes(35);
        assertEquals("",bos.toString());
    }

    @Test
    public void testRow11(){ 
        ActivityTracker tracker = new ActivityTracker(120);
        tracker.logMinutes(35);

        String  expectedOutput = "35135false";
        String w = Integer.toString(tracker.getTotalMinutes());
        w+=Integer.toString(tracker.getSessions());
        w+=Integer.toString(tracker.getMaxMinutes());
        w+=String.valueOf(tracker.goalAchieved());
        
        assertEquals(expectedOutput,w);
    }

  
    @Test
    public void testRow13(){ 
        ActivityTracker tracker = new ActivityTracker(120);
        tracker.logMinutes(35);
        tracker.logMinutes(30);

        String  expectedOutput = "65235false";
        String w = Integer.toString(tracker.getTotalMinutes());
        w+=Integer.toString(tracker.getSessions());
        w+=Integer.toString(tracker.getMaxMinutes());
        w+=String.valueOf(tracker.goalAchieved());
        
        assertEquals(expectedOutput,w);
    }

    @Test
    public void testRow14(){ 
        ActivityTracker tracker = new ActivityTracker(120);
        tracker.logMinutes(35);
        tracker.logMinutes(30);
        tracker.logMinutes(45);

        String  expectedOutput = "110345false";
        String w = Integer.toString(tracker.getTotalMinutes());
        w+=Integer.toString(tracker.getSessions());
        w+=Integer.toString(tracker.getMaxMinutes());
        w+=String.valueOf(tracker.goalAchieved());
        
        assertEquals(expectedOutput,w);
    }

    @Test
    public void testRow17(){ 
        ActivityTracker tracker = new ActivityTracker(120);
        tracker.logMinutes(35);
        tracker.logMinutes(30);
        tracker.logMinutes(45);
        tracker.logMinutes(15);

        String  expectedOutput = "125445true";
        String w = Integer.toString(tracker.getTotalMinutes());
        w+=Integer.toString(tracker.getSessions());
        w+=Integer.toString(tracker.getMaxMinutes());
        w+=String.valueOf(tracker.goalAchieved());
        
        assertEquals(expectedOutput,w);
    }


}
