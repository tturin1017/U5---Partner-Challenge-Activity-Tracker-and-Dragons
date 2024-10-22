package com.example.project;

public class ActivityTracker {
    private int targetGoal;
    private int totalMinutes;
    private int sessions;
    private int maxMinutes;

    public ActivityTracker(int targetGoal) {
        this.targetGoal = targetGoal;
        totalMinutes = 0; // default value
        sessions = 0; // default value
        maxMinutes = 0; // default value
    }

    public int getTargetGoal(){
        return targetGoal;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public int getSessions() {
        return sessions;
    }

    public int getMaxMinutes() {
        return maxMinutes;
    }

    public void logMinutes(int minutes) {
        totalMinutes += minutes;
        sessions++;
        if (minutes > maxMinutes) {
            maxMinutes = minutes;
        }
    }

    public boolean goalAchieved() {
        return (totalMinutes >= targetGoal);

        // or:  if (totalMinutes >= targetGoal) {
        //         return true;
        //      } else {
        //         return false;
        //      }
    }
}



