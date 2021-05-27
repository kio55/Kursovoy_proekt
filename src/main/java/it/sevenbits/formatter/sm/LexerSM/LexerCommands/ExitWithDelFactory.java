package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * default factory for exit with del command
 */
public class ExitWithDelFactory implements ICommandFactory {
    @Override
    public ICommand getCommand(final StringBuilder buffer, final StringBuilder lexeme, final char symbol,
                               final String type, final StringBuilder name) {
        return new ExitWithDel(lexeme);
    }
}
