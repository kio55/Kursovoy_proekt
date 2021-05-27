package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * default factory for ReadSymbol command
 */
public class ReadSymbolCommandFactory implements ICommandFactory {
    @Override
    public ICommand getCommand(final StringBuilder buffer, final StringBuilder lexeme,
                               final char symbol, final String type, final StringBuilder name) {
        return new ReadSymbol(buffer, lexeme, symbol, type, name);
    }
}
