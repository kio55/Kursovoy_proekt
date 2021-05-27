package it.sevenbits.formatter.sm.FormatterSM.FormatterCommands;

import it.sevenbits.formatter.Lexer.IToken;
import it.sevenbits.formatter.Writer.IWriter;

/**
 * default factory for SymbolLineBreakSpacesLowerFactory command
 */
public class SymbolLineBreakSpacesLowerFactory implements IFormatterCommandFactory {
    @Override
    public IFormatterCommand getCommand(final CountOfSpaces countOfSpaces, final IToken curToken, final IWriter writer) {
        return new SymbolLineBreakSpacesLower(countOfSpaces, curToken, writer);
    }
}
