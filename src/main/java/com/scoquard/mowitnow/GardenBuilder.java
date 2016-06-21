package com.scoquard.mowitnow;

import com.scoquard.mowitnow.core.IGarden;
import com.scoquard.mowitnow.core.IGardenBuilder;
import com.scoquard.mowitnow.core.IMower;
import com.scoquard.mowitnow.farm.*;
import com.scoquard.mowitnow.tools.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Parses a file
 *
 * Created by scoquard on 17/06/2016.
 */
public class GardenBuilder implements IGardenBuilder {

    private static final Logger logger = LogManager.getLogger(GardenBuilder.class);

    private File file;
    private BufferedReader bufferedReader;
    private int row;
    private int mowerCount;

    /**
     *
     * @param file to be parsed
     */
    public GardenBuilder(File file) {
        this.file = file;
    }

    private void init() throws FileNotFoundException {
        FileReader fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        row = 1;
        mowerCount = 0;
    }

    @Override
    public IGarden build() {
        try {
            init();

            List<IMower> mowers = new ArrayList<>();
            Stream<String> linesStream = bufferedReader.lines();

            Iterator<String> iterator = linesStream.iterator();

            //First line: dimensions of the garden
            String dimensionsAsString = iterator.next();
            Dimensions dimensions = Utils.parseDimensions(dimensionsAsString);

            Position initialPosition = null;
            while (iterator.hasNext()) {
                //The line is odd: the line is the initial position.
                if (row % 2 == 1) {
                    String initialPositionAsString = iterator.next();
                    initialPosition = Utils.parsePosition(initialPositionAsString);
                    mowerCount++;
                //The line is even: the line is the sequenc of instructions
                } else {
                    String instructionsAsString = iterator.next();
                    List<Instruction> instructions = Utils.parseInstructions(instructionsAsString);
                    Mower mower = new Mower(Integer.toString(mowerCount), initialPosition, instructions);
                    mowers.add(mower);
                }
                row++;
            }

            return new Garden(dimensions, mowers);
        } catch (IOException | GardenParsingException e) {
            logger.error(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                logger.error(e);
            }
        }
        return null;
    }
}
