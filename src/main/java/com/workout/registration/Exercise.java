package com.workout.registration;

import java.sql.Date;

public class Exercise {
    private String name;

    private int sets;
    private int reps;


    public Exercise(String name,  int sets, int reps) {
        this.name = name;
        this.sets= sets;
        this.reps=reps;

    }

    public int getReps(){return reps;}
    public void setReps(int reps){
        this.reps= reps;
    }
    public int getSets(){return sets;}
    public void setSets(int sets){
        this.sets= sets;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
