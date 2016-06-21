package com.scoquard.mowitnow.farm;

import com.scoquard.mowitnow.Cardinal;
import com.scoquard.mowitnow.Instruction;
import com.scoquard.mowitnow.core.IMower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * A mower in the garden
 * <p>
 * Created by scoquard on 17/06/2016.
 */
public class Mower implements IMower {

    private static final Logger logger = LogManager.getLogger(Mower.class);

    private String name;
    private Position position;
    private List<Instruction> instructions;

    /**
     * Constructs a mower with
     *
     * @param name            the name of the mower
     * @param initialPosition of the mower
     * @param instructions    to mow
     */
    public Mower(final String name, Position initialPosition, final List<Instruction> instructions) {
        this.name = name;
        this.position = initialPosition;
        this.instructions = instructions;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public List<Instruction> getInstructions() {
        return instructions;
    }

    @Override
    public void useThis(Dimensions gardenDimensions) {
        logger.info("Starting mowing with mower " + getName() + "...");
        for (Instruction instruction : getInstructions()) {
            Position newPosition;
            if (Instruction.A.equals(instruction)) {
                newPosition = move();
            } else {
                newPosition = rotate(instruction);
            }
            if (newPositionWithinGarden(newPosition, gardenDimensions)) {
                this.position = newPosition;
            } else {
                logger.debug("Move would put the mower out of the garden. Stay where you are");
            }
            logger.debug("New position: " + getPosition().toString());
        }
    }

    private boolean newPositionWithinGarden(Position newPosition, Dimensions gardenDimensions) {
        int x = newPosition.getX();
        int y = newPosition.getY();
        return x >= 0 && x <= gardenDimensions.getX() &&
                y >= 0 && y <= gardenDimensions.getY();
    }

    private Position rotate(Instruction instruction) {
        Cardinal newOrientation;
        if (Instruction.G.equals(instruction)) {
            newOrientation = getPosition().getOrientation().rotateLeft();
        } else {
            newOrientation = getPosition().getOrientation().rotateRight();
        }
        return new Position(getPosition().getX(), getPosition().getY(), newOrientation);
    }

    private Position move() {
        Cardinal orientation = getPosition().getOrientation();
        switch (orientation) {
            case N:
                return moveUp();
            case E:
                return moveRight();
            case S:
                return moveDown();
            case W:
                return moveLeft();
            default:
                throw new IllegalArgumentException("This case is not supported");
        }
    }

    private Position moveUp() {
        return new Position(getPosition().getX(), getPosition().getY() + 1, getPosition().getOrientation());
    }

    private Position moveDown() {
        return new Position(getPosition().getX(), getPosition().getY() - 1, getPosition().getOrientation());
    }

    private Position moveRight() {
        return new Position(getPosition().getX() + 1, getPosition().getY(), getPosition().getOrientation());
    }

    private Position moveLeft() {
        return new Position(getPosition().getX() - 1, getPosition().getY(), getPosition().getOrientation());
    }

    @Override
    public void printPosition() {
        logger.info("The position of the mower " + getName() + " is " + getPosition().toString());
    }
}