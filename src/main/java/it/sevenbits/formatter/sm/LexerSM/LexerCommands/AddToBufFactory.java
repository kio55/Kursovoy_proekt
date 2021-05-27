package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * Default factory for AddToBufCommand
 */
public class AddToBufFactory implements ICommandFactory {
    @Override
    public ICommand getCommand(final StringBuilder buffer, final StringBuilder lexeme, final char symbol,
                               final String type, final StringBuilder name) {
        return new AddToBuf(buffer, lexeme, symbol, type, name);
    }
}
