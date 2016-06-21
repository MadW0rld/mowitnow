package com.scoquard.mowitnow;

import com.scoquard.mowitnow.farm.Dimensions;
import com.scoquard.mowitnow.farm.Garden;
import com.scoquard.mowitnow.farm.Mower;
import com.scoquard.mowitnow.farm.Position;
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
public class GardenBuilder {

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

    /**
     * Builds the garden
     * @return a freshly built garden
     */
    public Garden build() {
        try {
            init();

            List<Mower> mowers = new ArrayList<>();
            Stream<String> linesStream = bufferedReader.lines();

            Iterator<String> iterator = linesStream.iterator();

            String dimensionsAsString = iterator.next();
            Dimensions dimensions = Utils.parseDimensions(dimensionsAsString);

            Position initialPosition = null;
            while (iterator.hasNext()) {
                if (row % 2 == 1) {
                    String initialPositionAsString = iterator.next();
                    initialPosition = Utils.parsePosition(initialPositionAsString);
                    mowerCount++;
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
