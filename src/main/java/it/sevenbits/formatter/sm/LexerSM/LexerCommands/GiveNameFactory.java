package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * default factory for GiveName command
 */
public class GiveNameFactory implements ICommandFactory {
    @Override
    public ICommand getCommand(final StringBuilder buffer, final StringBuilder lexeme, final char symbol,
                               final String type, final StringBuilder name) {
        return new GiveName(buffer, lexeme, symbol, type, name);
    }
}
