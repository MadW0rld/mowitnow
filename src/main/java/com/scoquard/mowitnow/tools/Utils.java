package com.scoquard.mowitnow.tools;

import com.scoquard.mowitnow.*;
import com.scoquard.mowitnow.farm.Cardinal;
import com.scoquard.mowitnow.farm.Dimensions;
import com.scoquard.mowitnow.farm.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Utilities to plow garden
 *
 * Created by scoquard on 19/06/2016.
 */
public class Utils {

    private static final String DIMENSIONSPATTERN = "(\\d* \\d*){1}";
    private static final String INSTRUCTIONSPATTERN = "(A|G|D)*";
    private static final String POSITIONPATTERN = "\\d* \\d* (N|E|W|S){1}";

    private Utils() {}

    /**
     * Parses a string to a position
     * @param positionAsString formatted 'x y O' with O = orientation
     * @return the parsed {@link com.scoquard.mowitnow.farm.Position}
     * @throws GardenParsingException
     */
    public static Position parsePosition(String positionAsString) throws GardenParsingException {
        if (!isPosition(positionAsString)) {
            throw new GardenParsingException("Wrong format for position in file. It should be formatted as 'x y O' with O belongs to {N, E, W, S}");
        }
        StringTokenizer tokenizer = new StringTokenizer(positionAsString.trim(), " ");
        int x = Integer.parseInt(tokenizer.nextToken());
        int y = Integer.parseInt(tokenizer.nextToken());
        Cardinal orientation = Enum.valueOf(Cardinal.class, tokenizer.nextToken());

        return new Position(x, y, orientation);
    }

    /**
     * Parses a string of instructions to a list
     * @param instructionsAsString formatted 'x y O' with O = orientation
     * @return a list of {@link com.scoquard.mowitnow.Instruction}
     * @throws GardenParsingException
     */
    public static List<Instruction> parseInstructions(String instructionsAsString) throws GardenParsingException {
        if (!isInstructions(instructionsAsString)) {
            throw new GardenParsingException("Wrong format for instructions in file. It should contain only A, G or D");
        }
        List<Instruction> instructions = new ArrayList<>();
        for (char character : instructionsAsString.trim().toCharArray()) {
            Instruction instructionEnum = Enum.valueOf(Instruction.class, Character.toString(character));
            instructions.add(instructionEnum);
        }
        return instructions;
    }

    /**
     * Parses a string to a dimension
     * @param dimensionsAsString formatted 'x y'
     * @return the parsed {@link com.scoquard.mowitnow.farm.Dimensions}
     * @throws GardenParsingException
     */
    public static Dimensions parseDimensions(String dimensionsAsString) throws GardenParsingException {
        if (!isDimensions(dimensionsAsString)) {
            throw new GardenParsingException("Wrong format for dimensions in file. It should be formatted like 'x y'");
        }
        StringTokenizer tokenizer = new StringTokenizer(dimensionsAsString.trim(), " ");
        int[] dimensionsArray = new int[2];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            dimensionsArray[i] = Integer.parseInt(tokenizer.nextToken());
            i ++;
        }

        return new Dimensions(dimensionsArray[0], dimensionsArray[1]);
    }

    private static boolean isPosition(String positionAsString) {
        return matchesRegExp(POSITIONPATTERN, positionAsString);
    }

    private static boolean isInstructions(String instructionsAsString) {
        return matchesRegExp(INSTRUCTIONSPATTERN, instructionsAsString);
    }

    private static boolean isDimensions(String dimensionsAsString) {
        return matchesRegExp(DIMENSIONSPATTERN, dimensionsAsString);
    }

    private static boolean matchesRegExp(String pattern, String value) {
        return Pattern.matches(pattern, value);
    }
}
