package com.scoquard.mowitnow;

/**
 * Exception during parsing of the file describing the garden
 *
 * Created by scoquard on 20/06/2016.
 */
public class GardenParsingException extends Exception {

    /**
     * Constructs a new exception
     * @param message of the exception
     */
    public GardenParsingException(String message) {
        super(message);
    }
}
