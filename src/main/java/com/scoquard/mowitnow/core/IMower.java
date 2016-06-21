package com.scoquard.mowitnow.core;

import com.scoquard.mowitnow.Instruction;
import com.scoquard.mowitnow.farm.Dimensions;
import com.scoquard.mowitnow.farm.Position;

import java.util.List;

/**
 * Interface of the mower
 *
 * Created by scoquard on 21/06/2016.
 */
public interface IMower {

    /**
     * The name of the mower
     * @return the name
     */
    String getName();

    /**
     * The current position of the mower
     * @return {@link com.scoquard.mowitnow.farm.Position}
     */
    Position getPosition();

    /**
     * List of instructions passed to the mower
     * @return a list of {@link com.scoquard.mowitnow.Instruction}
     */
    List<Instruction> getInstructions();

    /**
     * use this mower
     * @param dimensions of the garden
     */
    void useThis(Dimensions dimensions);

    /**
     * Prints the current position of the mower
     */
    void printPosition();
}
