package it.sevenbits.formatter.sm.FormatterSM.FormatterCommands;

import it.sevenbits.formatter.Exceptions.StreamException;

/**
 * interface of formatter commands
 */
public interface IFormatterCommand {
    /**
     * make some actions with token
     * @throws StreamException if cant write to the file
     */
    void execute() throws StreamException;
}
