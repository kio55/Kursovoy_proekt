package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * default factory for Ignore command
 */
public class IgnoreCommandFactory implements ICommandFactory {
    @Override
    public ICommand getCommand(final StringBuilder buffer, final StringBuilder lexeme,
                               final char symbol, final String type, final StringBuilder name) {
        return new Ignore();
    }
}
