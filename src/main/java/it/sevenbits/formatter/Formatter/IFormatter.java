package it.sevenbits.formatter.Formatter;

import it.sevenbits.formatter.Exceptions.StreamException;
import it.sevenbits.formatter.Reader.IReader;
import it.sevenbits.formatter.Writer.IWriter;

/**
 * Interface for refactor code
 */
public interface IFormatter {
    /**
     * refactor code
     * @param reader input code
     * @param writer output code
     * @throws StreamException if input or output errors
     */
    void format(IReader reader, IWriter writer) throws StreamException;
}
