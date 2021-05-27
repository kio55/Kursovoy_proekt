package it.sevenbits.formatter.Reader;

import it.sevenbits.formatter.Exceptions.StreamException;

/**
 * Interface for character-by-character reading
 */
public interface IReader {
    /**
     * Reads a character
     *
     * @return character
     * @throws StreamException thrown when an error occurs, the stream to read
     */
    char read() throws StreamException;

    /**
     * Checks for subsequent elements
     *
     * @return is further reading possible
     * @throws StreamException thrown when an error occurs, the stream to read
     */
    boolean hasNext() throws StreamException;
}
