package com.example.project;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.beans.Transient;
import java.io.*;


public class TestDragon{

    @Test
    public void testRow2(){
        Dragon dragon = new Dragon();
        String expectedOutput = "Dragon: ";
        expectedOutput += "\nStrength = 1";
        expectedOutput += "\nHealth = 100";
        expectedOutput += "\nLevel = 1";
        expectedOutput += "\nDead = false";
        expectedOutput += "\nAttack Damage = 0";
        String studentOutput = dragon.state();
        assertEquals(expectedOutput,studentOutput);
    }

    @Test
    public void testRow3(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Dragon dragon = new Dragon();
        dragon.attack();
        assertEquals("The dragon attacks for 1 health!\n",bos.toString());
    }

    @Test
    public void testRow4(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        Dragon dragon = new Dragon();
        dragon.takeDamage(20);
        assertEquals("The dragon takes 20 damage and now has 80 health.\n",bos.toString());
    }

    @Test
    public void testRow5(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        Dragon dragon = new Dragon();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        assertEquals("The dragon takes 20 damage and now has 80 health.\n" + //
                        "The dragon's health has increased to 160\n",bos.toString());
    }

    @Test
    public void testRow6(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        Dragon dragon = new Dragon();
        // dragon.takeDamage(20);
        // dragon.powerUp(1);
        dragon.powerUp(2);
        assertEquals("The dragon's strength has increased to 2\n",bos.toString());
    }

    @Test
    public void testRow7(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        Dragon dragon = new Dragon();

        dragon.powerUp(2);
        //System.setOut(originalOut);
        dragon.powerUp(2);
        assertEquals("The dragon's strength has increased to 2\n" + //
                        "The dragon's strength has increased to 4\n",bos.toString());
    }

    @Test
    public void testRow8(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        Dragon dragon = new Dragon();

        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        assertEquals("The dragon's strength has increased to 2\n"+
        "The dragon's strength has increased to 4\n"+
        "The dragon's strength has increased to 8\n",bos.toString());
    }

    @Test
    public void testRow9(){
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        int studentOutput = dragon.attack();
        int expectedOutput = 8;
        assertEquals(studentOutput,expectedOutput);
    }

    @Test
    public void testRow11(){
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();
        String studentOutput = dragon.state();
        String expectedOutput = "Dragon: ";
        expectedOutput += "\nStrength = 8";
        expectedOutput += "\nHealth = 160";
        expectedOutput += "\nLevel = 1";
        expectedOutput += "\nDead = false";
        expectedOutput += "\nAttack Damage = 9";

        assertEquals(expectedOutput,studentOutput);
    }

    @Test
    public void testRow12(){ 
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();

        //redirect system.out to the bytearrayoutputstream
        PrintStream originalOut = System.out;
        // setup stream to capture output
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        System.setOut(ps);
        dragon.takeDamage(70);//output will go to bos
        //flush printstream to ensure all data is written
        ps.flush();
        //reset system.out to its original state
        System.setOut(originalOut);
        assertEquals("The dragon takes 70 damage and now has 90 health.\n",bos.toString());
    }

    @Test
    public void testRow13(){ 
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();
        dragon.takeDamage(70);//output will go to bos

        //redirect system.out to the bytearrayoutputstream
        PrintStream originalOut = System.out;
        // setup stream to capture output
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        System.setOut(ps);

        dragon.powerUp(2);

        //flush printstream to ensure all data is written
        ps.flush();
        //reset system.out to its original state
        System.setOut(originalOut);
        assertEquals("The dragon's strength has increased to 16\n",bos.toString());
    }

    @Test
    public void testRow14(){ 
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();
        dragon.takeDamage(70);//output will go to bos
        dragon.powerUp(2);

        //redirect system.out to the bytearrayoutputstream
        PrintStream originalOut = System.out;
        // setup stream to capture output
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        System.setOut(ps);

        dragon.attack();

        //flush printstream to ensure all data is written
        ps.flush();
        //reset system.out to its original state
        System.setOut(originalOut);
        assertEquals("The dragon attacks for 16 health!\n",bos.toString());
    }

    @Test
    public void testRow15(){ 
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();
        dragon.takeDamage(70);//output will go to bos
        dragon.powerUp(2);
        dragon.attack();

        //redirect system.out to the bytearrayoutputstream
        PrintStream originalOut = System.out;
        // setup stream to capture output
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        System.setOut(ps);

        dragon.powerUp(2);

        //flush printstream to ensure all data is written
        ps.flush();
        //reset system.out to its original state
        System.setOut(originalOut);
        assertEquals("The dragon's strength has increased to 32\n",bos.toString());
    }

    @Test
    public void testRow16(){ 
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();
        dragon.takeDamage(70);//output will go to bos
        dragon.powerUp(2);
        dragon.attack();
        dragon.powerUp(2);
        String studentOutput = dragon.state();

        String expectedOutput = "Dragon: ";
        expectedOutput += "\nStrength = 32";
        expectedOutput += "\nHealth = 90";
        expectedOutput += "\nLevel = 1";
        expectedOutput += "\nDead = false";
        expectedOutput += "\nAttack Damage = 25";
        
        assertEquals(expectedOutput,studentOutput);
    }

    @Test
    public void testRow17(){ 
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();
        dragon.takeDamage(70);//output will go to bos
        dragon.powerUp(2);
        dragon.attack();
        dragon.powerUp(2);

        //redirect system.out to the bytearrayoutputstream
        PrintStream originalOut = System.out;
        // setup stream to capture output
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        System.setOut(ps);

        dragon.attack();

        //flush printstream to ensure all data is written
        ps.flush();
        //reset system.out to its original state
        System.setOut(originalOut);
        assertEquals("The dragon attacks for 32 health!\n"
        +"The dragon has reached level 2!\n",bos.toString());
    }

    @Test
    public void testRow18(){ 
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();
        dragon.takeDamage(70);//output will go to bos
        dragon.powerUp(2);
        dragon.attack();
        dragon.powerUp(2);
        dragon.attack();
        String studentOutput = dragon.state();

        String expectedOutput = "Dragon: ";
        expectedOutput += "\nStrength = 32";
        expectedOutput += "\nHealth = 90";
        expectedOutput += "\nLevel = 2";
        expectedOutput += "\nDead = false";
        expectedOutput += "\nAttack Damage = 0";
        
        assertEquals(expectedOutput,studentOutput);
    }

    @Test
    public void testRow19(){ 
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();
        dragon.takeDamage(70);//output will go to bos
        dragon.powerUp(2);
        dragon.attack();
        dragon.powerUp(2);
        

        //redirect system.out to the bytearrayoutputstream
        PrintStream originalOut = System.out;
        // setup stream to capture output
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        System.setOut(ps);

        dragon.takeDamage(65);

        //flush printstream to ensure all data is written
        ps.flush();
        //reset system.out to its original state
        System.setOut(originalOut);
        assertEquals("The dragon takes 65 damage and now has 25 health.\n",bos.toString());
    }

    @Test
    public void testRow20(){ 
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();
        dragon.takeDamage(70);//output will go to bos
        dragon.powerUp(2);
        dragon.attack();
        dragon.powerUp(2);
        dragon.takeDamage(65);
        

        //redirect system.out to the bytearrayoutputstream
        PrintStream originalOut = System.out;
        // setup stream to capture output
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        System.setOut(ps);

        dragon.takeDamage(40);

        //flush printstream to ensure all data is written
        ps.flush();
        //reset system.out to its original state
        System.setOut(originalOut);
        assertEquals("The dragon takes 40 damage and now has 0 health.\n"+
        "The dragon has been slayed!\n",bos.toString());
    }

    @Test
    public void testRow21(){ 
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();
        dragon.takeDamage(70);//output will go to bos
        dragon.powerUp(2);
        dragon.attack();
        dragon.powerUp(2);
        dragon.takeDamage(65);
        dragon.takeDamage(40);
        

        //redirect system.out to the bytearrayoutputstream
        PrintStream originalOut = System.out;
        // setup stream to capture output
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        System.setOut(ps);

        dragon.takeDamage(10);

        //flush printstream to ensure all data is written
        ps.flush();
        //reset system.out to its original state
        System.setOut(originalOut);
        assertEquals("The dragon is already dead!\n",bos.toString());
    }

    @Test
    public void testRow22(){ 
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();
        dragon.takeDamage(70);//output will go to bos
        dragon.powerUp(2);
        dragon.attack();
        dragon.powerUp(2);
        dragon.attack();
        dragon.takeDamage(65);
        dragon.takeDamage(40);
        dragon.takeDamage(10);
        String studentOutput = dragon.state();

        String expectedOutput = "Dragon: ";
        expectedOutput += "\nStrength = 32";
        expectedOutput += "\nHealth = 0";
        expectedOutput += "\nLevel = 2";
        expectedOutput += "\nDead = true";
        expectedOutput += "\nAttack Damage = 0";
        
        assertEquals(expectedOutput,studentOutput);
    }

    @Test
    public void testRow23(){ 
        Dragon dragon = new Dragon();
        dragon.attack();
        dragon.takeDamage(20);
        dragon.powerUp(1);
        dragon.powerUp(2);
        dragon.powerUp(2);
        dragon.powerUp(8);
        dragon.state();
        dragon.attack();
        dragon.takeDamage(70);//output will go to bos
        dragon.powerUp(2);
        dragon.attack();
        dragon.powerUp(2);
        dragon.attack();
        dragon.takeDamage(65);
        dragon.takeDamage(40);
        dragon.takeDamage(10);
        String studentOutput = "3202true";
        String expectedOutput = Integer.toString(dragon.getStrength())
        +Integer.toString(dragon.getHealth())
        + Integer.toString(dragon.getLevel())
        + String.valueOf(dragon.isDead());       
        assertEquals(expectedOutput,studentOutput);
    }




}