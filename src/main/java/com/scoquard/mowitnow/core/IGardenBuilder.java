package com.scoquard.mowitnow.core;

/**
 * Interface of a garden builder
 * Created by scoquard on 21/06/2016.
 */
@FunctionalInterface
public interface IGardenBuilder {

    /**
     * Builds the garden
     * @return a freshly built garden
     */
    IGarden build();
}
