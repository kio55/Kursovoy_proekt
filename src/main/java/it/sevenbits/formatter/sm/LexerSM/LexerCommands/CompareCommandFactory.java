package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * default factory for Compare command
 */
public class CompareCommandFactory implements ICommandFactory {
    @Override
    public ICommand getCommand(final StringBuilder buffer, final StringBuilder lexeme, final char symbol,
                               final String type, final StringBuilder name) {
        return new Compare(buffer, lexeme, symbol, type, name);
    }
}
