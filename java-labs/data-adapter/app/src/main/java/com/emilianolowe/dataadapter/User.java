package com.emilianolowe.dataadapter;

import java.util.ArrayList;

public class User {

    //declare private data instead of public to ensure the privacy of data field of each class
    public String name;
    public String hometown;

    public User(String name, String hometown) {
        this.name = name;
        this.hometown = hometown;
    }

    //retrieve user's name
    public String getName(){
        return name;
    }

    //retrieve users' hometown
    public String getHometown(){
        return hometown;
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Emiliano", "San Francisco"));
        users.add(new User("Kanya", "Austin"));
        users.add(new User("Nadine", "Trinidad"));
        users.add(new User("Laurenco", "San Pao"));
        users.add(new User("Felipe", "Mexico"));
        users.add(new User("Rainer", "Estonia"));
        users.add(new User("Paul", "Ireland"));
        users.add(new User("Rodrigo", "San Pao"));
        users.add(new User("Danilo", "San Pao"));
        users.add(new User("Peter", "Seoul"));
        return users;
    }
}
