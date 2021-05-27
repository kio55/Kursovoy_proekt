package it.sevenbits.formatter.Writer;

import it.sevenbits.formatter.Exceptions.StreamException;

/**
 * Interface for character-by-character writing
 */
public interface IWriter {
    /**
     * Method for writing a single character
     * @param character character to write
     * @throws StreamException thrown when an error occurs, the stream to write
     */
    void write(char character) throws StreamException;
}
