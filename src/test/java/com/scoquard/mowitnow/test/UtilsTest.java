package com.scoquard.mowitnow.test;

import com.scoquard.mowitnow.GardenParsingException;
import com.scoquard.mowitnow.Instruction;
import com.scoquard.mowitnow.Cardinal;
import com.scoquard.mowitnow.farm.Dimensions;
import com.scoquard.mowitnow.farm.Position;
import com.scoquard.mowitnow.tools.Utils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.contrib.java.lang.throwable.When.when;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the {@link com.scoquard.mowitnow.tools.Utils} class
 * Created by scoquard on 20/06/2016.
 */
public class UtilsTest {

    @Test
    public void testIfDimensionsExceptionIsThrownWhenWrongFormat() {
        when(() -> Utils.parseDimensions("ab a"))
                .thenA(GardenParsingException.class)
                .isThrown();
    }

    @Test
    public void testIfDimensionsExceptionIsThrownWhenNegative() {
        when(() -> Utils.parseDimensions("-5 5"))
                .thenA(GardenParsingException.class)
                .isThrown();
    }

    @Test
    public void testParseDimensions() {
        try {
            Dimensions dimensions = Utils.parseDimensions("5 5");
            assertEquals(dimensions, new Dimensions(5, 5));
        } catch (GardenParsingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIfInstructionsExceptionIsThrown() {
        when(() -> Utils.parseInstructions("AG1DG"))
                .thenA(GardenParsingException.class)
                .isThrown();
    }

    @Test
    public void testParseInstructions() {
        try {
            List<Instruction> instructions = Utils.parseInstructions("AGDDGA");
            assertEquals(instructions, Arrays.asList(Instruction.A, Instruction.G, Instruction.D, Instruction.D, Instruction.G, Instruction.A));
        } catch (GardenParsingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIfPositionExceptionIsThrown() {
        when(() -> Utils.parseInstructions("AG1DG"))
                .thenA(GardenParsingException.class)
                .isThrown();
    }

    @Test
    public void testParsePosition() {
        try {
            Position position = Utils.parsePosition("3 1 W");
            assertEquals(position, new Position(3, 1, Cardinal.W));
        } catch (GardenParsingException e) {
            e.printStackTrace();
        }
    }
}
