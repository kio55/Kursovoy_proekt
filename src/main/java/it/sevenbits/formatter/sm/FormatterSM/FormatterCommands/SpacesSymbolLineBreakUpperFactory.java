package it.sevenbits.formatter.sm.FormatterSM.FormatterCommands;

import it.sevenbits.formatter.Lexer.IToken;
import it.sevenbits.formatter.Writer.IWriter;

/**
 * Default factory for SpacesSymbolLineBreakUpper command
 */
public class SpacesSymbolLineBreakUpperFactory implements IFormatterCommandFactory {
    @Override
    public IFormatterCommand getCommand(final CountOfSpaces countOfSpaces, final IToken curToken, final IWriter writer) {
        return new SpacesSymbolLineBreakUpper(countOfSpaces, curToken, writer);
    }
}
