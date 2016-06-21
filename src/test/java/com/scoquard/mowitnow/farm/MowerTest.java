package com.scoquard.mowitnow.farm;

import com.scoquard.mowitnow.Cardinal;
import com.scoquard.mowitnow.Instruction;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Tests the mower
 * Created by scoquard on 20/06/2016.
 */
public class MowerTest {

    @Test
    public void testMowerDoesNotMoveWhenOutOfGarden() {
        Mower mower = new Mower("test", new Position(5, 0, Cardinal.E), Collections.singletonList(Instruction.A));
        mower.useThis(new Dimensions(5, 5));
        assertEquals(mower.getPosition(), new Position(5, 0, Cardinal.E));
    }

    @Test
    public void testMowerMovesEast() {
        Mower mower = new Mower("test", new Position(0, 0, Cardinal.E), Collections.singletonList(Instruction.A));
        mower.useThis(new Dimensions(5, 5));
        assertEquals(mower.getPosition(), new Position(1, 0, Cardinal.E));
    }

    @Test
    public void testMowerMovesNorth() {
        Mower mower = new Mower("test", new Position(1, 0, Cardinal.N), Collections.singletonList(Instruction.A));
        mower.useThis(new Dimensions(5, 5));
        assertEquals(mower.getPosition(), new Position(1, 1, Cardinal.N));
    }

    @Test
    public void testMowerMovesWest() {
        Mower mower = new Mower("test", new Position(1, 1, Cardinal.W), Collections.singletonList(Instruction.A));
        mower.useThis(new Dimensions(5, 5));
        assertEquals(mower.getPosition(), new Position(0, 1, Cardinal.W));
    }

    @Test
    public void testMowerMovesSouth() {
        Mower mower = new Mower("test", new Position(0, 1, Cardinal.S), Collections.singletonList(Instruction.A));
        mower.useThis(new Dimensions(5, 5));
        assertEquals(mower.getPosition(), new Position(0, 0, Cardinal.S));
    }
}
