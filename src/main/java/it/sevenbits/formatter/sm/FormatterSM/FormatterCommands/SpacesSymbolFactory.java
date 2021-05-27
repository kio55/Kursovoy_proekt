package it.sevenbits.formatter.sm.FormatterSM.FormatterCommands;

import it.sevenbits.formatter.Lexer.IToken;
import it.sevenbits.formatter.Writer.IWriter;

/**
 * default factory for the SpacesSymbol command
 */
public class SpacesSymbolFactory implements IFormatterCommandFactory {

    @Override
    public IFormatterCommand getCommand(final CountOfSpaces countOfSpaces, final IToken curToken, final IWriter writer) {
        return new SpacesSymbol(countOfSpaces, curToken, writer);
    }
}
