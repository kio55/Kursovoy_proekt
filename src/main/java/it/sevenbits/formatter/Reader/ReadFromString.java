package it.sevenbits.formatter.Reader;

import it.sevenbits.formatter.Exceptions.StreamException;

/**
 * class for character-by-character reading of information from string
 */
public class ReadFromString implements IReader {
    private final String inputString;
    private int currElem;

    /**
     * Standard constructor
     * @param inputString The reading line
     */
    public ReadFromString(final String inputString) {
        this.inputString = inputString;
        this.currElem = 0;
    }


    @Override
    public char read() throws StreamException {
        if (!inputString.equals("")) {
            char c = inputString.charAt(currElem);
            currElem++;
            return c;
        } else {
            throw new StreamException("Incorrect input");
        }
    }

    @Override
    public boolean hasNext() {
        return currElem < inputString.length();
    }

}
