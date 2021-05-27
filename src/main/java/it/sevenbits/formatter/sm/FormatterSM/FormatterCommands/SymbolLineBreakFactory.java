package it.sevenbits.formatter.sm.FormatterSM.FormatterCommands;

import it.sevenbits.formatter.Lexer.IToken;
import it.sevenbits.formatter.Writer.IWriter;

/**
 * default factory for SymbolLineBreak command
 */
public class SymbolLineBreakFactory implements IFormatterCommandFactory {
    @Override
    public IFormatterCommand getCommand(final CountOfSpaces countOfSpaces, final IToken curToken, final IWriter writer) {
        return new SymbolLineBreak(curToken, writer);
    }
}
