package com.example.project;

public class Dragon {
    private int strength;
    private int health;
    private int level;
    private boolean dead;
    private int attackDamageSum;
 
    public Dragon() {
        strength = 1;
        health = 100;
        level = 1;
        dead = false;
        attackDamageSum = 0;
    }
 
    public int getStrength() {
        return strength;
    }
 
    public int getHealth() {
        return health;
    }
 
    public int getLevel() {
        return level;
    }
 
    public boolean isDead() {
        return dead;
    }
 
    public void takeDamage(int damage) {
        if (!dead) {
            health -= damage;
            if (health <= 0) {
                dead = true;
                health = 0;
            }
            System.out.println("The dragon takes " + damage + " damage and now has " + health + " health.");
 
            if (dead) {
                System.out.println("The dragon has been slayed!");
            }
        } else {
            System.out.println("The dragon is already dead!");
        }
    }
 
    public void powerUp(int statChoice) {
        String selection;
        int amount;
 
        if (statChoice == 1) {
            health *= 2;
            selection = "health";
            amount = health;
        } else {
            strength *= 2;
            selection = "strength";
            amount = strength;
        }
        System.out.println("The dragon's " + selection + " has increased to " + amount);
    }
 
    public int attack() {
        int attackAmount = strength * level;
        System.out.println("The dragon attacks for " + attackAmount + " health!");
 
        if (attackDamageSum + attackAmount >= 50) {
            level++;
            System.out.println("The dragon has reached level " + level + "!");
            attackDamageSum = 0;
        } else {
            attackDamageSum += attackAmount;
        }
        return attackAmount;
    }
 
    public String state() {
        String output = "Dragon: ";
        output += "\nStrength = " + strength;
        output += "\nHealth = " + health;
        output += "\nLevel = " + level;
        output += "\nDead = " + dead;
        output += "\nAttack Damage = " + attackDamageSum;
 
        return output;
    }
}
 
 
 
 