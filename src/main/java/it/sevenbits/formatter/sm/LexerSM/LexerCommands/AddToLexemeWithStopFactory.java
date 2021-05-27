package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * default factory for AddToLexemeWithStop command
 */
public class AddToLexemeWithStopFactory implements ICommandFactory {
    @Override
    public ICommand getCommand(final StringBuilder buffer, final StringBuilder lexeme, final char symbol,
                               final String type, final StringBuilder name) {
        return new AddToLexemeWithStop(buffer, lexeme, symbol, type, name);
    }
}
