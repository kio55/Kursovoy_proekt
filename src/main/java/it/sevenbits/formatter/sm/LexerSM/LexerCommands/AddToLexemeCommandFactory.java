package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * default factory for AddToLexeme command
 */
public class AddToLexemeCommandFactory implements ICommandFactory {
    @Override
    public ICommand getCommand(final StringBuilder buffer, final StringBuilder lexeme, final char symbol,
                               final String type, final StringBuilder name) {
        return new AddToLexeme(lexeme, symbol);
    }
}
