package com.scoquard.mowitnow.core;

import com.scoquard.mowitnow.farm.Dimensions;

import java.util.List;

/**
 * Interface of the garden
 *
 * Created by scoquard on 21/06/2016.
 */
public interface IGarden {

    /**
     * Dimensions of the garden
     * @return {@link com.scoquard.mowitnow.farm.Dimensions}
     */
    Dimensions getDimensions();

    /**
     * Mowers in the garden
     * @return list of {@link com.scoquard.mowitnow.core.IMower}
     */
    List<IMower> getMowers();

    /**
     * Mow this garden
     */
    void mow();
}
