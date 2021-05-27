package it.sevenbits.formatter.Exceptions;

/**
 * thrown when an error occurs, the stream to write or read
 */
public class StreamException extends Exception {
    /**
     * The exception is when working with streams input / output
     * @param message explanatory message
     */
    public StreamException(final String message) {
        super(message);
    }
}
