package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * default factory for exit command
 */
public class ExitFactory implements ICommandFactory {
    @Override
    public ICommand getCommand(final StringBuilder buffer, final StringBuilder lexeme, final char symbol,
                               final String type, final StringBuilder name) {
        return new Exit();
    }
}
