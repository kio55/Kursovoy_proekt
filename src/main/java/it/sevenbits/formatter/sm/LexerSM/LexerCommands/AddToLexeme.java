package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * add symbol to lexeme
 */
public class AddToLexeme implements ICommand {
    private final StringBuilder lexeme;
    private final char symbol;

    /**
     * default constructor
     * @param lexeme current lexeme
     * @param symbol current symbol
     */
    public AddToLexeme(final StringBuilder lexeme, final char symbol) {
        this.lexeme = lexeme;
        this.symbol = symbol;
    }

    @Override
    public boolean execute() {
        lexeme.append(symbol);
        return true;
    }
}
