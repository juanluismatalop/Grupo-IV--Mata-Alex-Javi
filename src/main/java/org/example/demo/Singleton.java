package org.example.demo;

public class Singleton {
    private static Singleton singleton;

    private Singleton(){
    }

    public static Singleton setInstance(){
        if (singleton == null)
            singleton = new Singleton();
        return singleton;
    }
}
