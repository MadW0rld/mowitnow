package com.scoquard.mowitnow;

import com.scoquard.mowitnow.core.IGarden;

import java.io.*;

/**
 * Main class
 *
 * Created by scoquard on 17/06/2016.
 */
public class Main {

    private Main() {}

    /**
     * Main method
     * @param args entry parameters
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("You must enter a file path as an argument");
        }
        if (args.length > 1) {
            throw new IllegalArgumentException("Only one parameter allowed");
        }
        String fileName = args[0];
        File f = new File(fileName);

        GardenBuilder builder = new GardenBuilder(f);
        IGarden garden = builder.build();

        garden.mow();
    }
}
