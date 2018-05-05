package com.example.jokelib;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public final class JokeMachine {
    List<String> jokes = asList("joke1", "joke2", "joke3", "joke4");

    public String tellJoke() {
        return jokes.get(new Random().nextInt(3));
    }

//    public String tellJoke() {
//        return "Microsoft gives you Windows, Linux gives you a home!";
//    }

}
