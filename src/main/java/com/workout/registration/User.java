package com.workout.registration;

import java.sql.Date;

public class User {
    private String name;

    private String weight;

    private String height;
    private String email;
    private String password;

    private String re_pass;
    private boolean ban;
    private boolean admin;

    public User(String name,  String email, String password,String re_pass,String weight, String height) {
        this.name = name;
        this.weight= weight;
        this.height=height;
        this.email = email;
        this.password = password;
        this.re_pass= re_pass;
        this.ban = false;
        this.admin = false;
    }

    public String getRePass() {
        return re_pass;
    }

    public void setRePass(String re_pass) {
        this.re_pass = re_pass;
    }

    public void setBan(){ban = true;}
    public boolean getBan(){return ban;}

    public void setAdmin(){admin = true;}
    public boolean getAdmin(){return admin;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight(){return weight;}

    public void setWeight(String weight){ this.weight= weight ;}

    public String getHeight(){return height;}

    public void setHeight(String height){ this.height= height ;}
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void setGender(String gender) {
        this.password = gender;
    }
}
