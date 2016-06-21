package com.scoquard.mowitnow;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the rotation of the Instruction enum
 *
 * Created by scoquard on 20/06/2016.
 */
public class CardinalTest {

    @Test
    public void testRotateRight() {
        Cardinal eastRight = Cardinal.E.rotateRight();
        assertEquals(eastRight, Cardinal.S);

        Cardinal southRight = Cardinal.S.rotateRight();
        assertEquals(southRight, Cardinal.W);

        Cardinal westRight = Cardinal.W.rotateRight();
        assertEquals(westRight, Cardinal.N);

        Cardinal northRight = Cardinal.N.rotateRight();
        assertEquals(northRight, Cardinal.E);
    }

    @Test
    public void testRotateLeft() {
        Cardinal eastLeft = Cardinal.E.rotateLeft();
        assertEquals(eastLeft, Cardinal.N);

        Cardinal northLeft = Cardinal.N.rotateLeft();
        assertEquals(northLeft, Cardinal.W);

        Cardinal westLeft = Cardinal.W.rotateLeft();
        assertEquals(westLeft, Cardinal.S);

        Cardinal southLeft = Cardinal.S.rotateLeft();
        assertEquals(southLeft, Cardinal.E);
    }
}
