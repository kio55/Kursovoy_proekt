package it.sevenbits.formatter.sm.FormatterSM.FormatterCommands;

import it.sevenbits.formatter.Lexer.IToken;
import it.sevenbits.formatter.Writer.IWriter;

/**
 * Factory which return current command
 */
public interface IFormatterCommandFactory {
    /**
     * return current command
     * @param countOfSpaces count of spaces on the next line
     * @param curToken current token
     * @param writer where we write the result
     * @return current command
     */

    IFormatterCommand getCommand(CountOfSpaces countOfSpaces, IToken curToken, IWriter writer);
}
