package it.sevenbits.formatter.Writer;


import it.sevenbits.formatter.Exceptions.StreamException;

/**
 * Class for character-by-character writing to a string
 */
public class WriterToString implements IWriter {
    private final StringBuilder result = new StringBuilder();

    /**
     * Standard constructor
     */
    public WriterToString() {
    }

    public String getResult() {
        return result.toString();
    }

    @Override
    public void write(final char c) throws StreamException {
        result.append(c);
    }

}
