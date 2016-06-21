package com.scoquard.mowitnow.farm;

import com.scoquard.mowitnow.GardenBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * Main class
 *
 * Created by scoquard on 17/06/2016.
 */
public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    private Main() {}

    /**
     * Main method
     * @param args entry parameters
     */
    public static void main(String[] args) {
        if (args.length > 1) {
            logger.error("Only one parameter allowed");
        }
        String fileName = args[0];
        File f = new File(fileName);

        GardenBuilder builder = new GardenBuilder(f);
        Garden garden = builder.build();

        garden.mow();
    }
}
