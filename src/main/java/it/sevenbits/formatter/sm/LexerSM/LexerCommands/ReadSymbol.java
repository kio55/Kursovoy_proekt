package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * read current symbol and add to lexeme and set name
 */
public class ReadSymbol implements ICommand {
    private final StringBuilder lexeme;
    private final char symbol;
    private final StringBuilder name;
    private final String type;

    /**
     * default constructor
     *
     * @param buffer buffer with special symbol
     * @param lexeme current lexeme
     * @param symbol current symbol
     * @param type   type of current symbol
     * @param name   name of lexeme
     */
    public ReadSymbol(final StringBuilder buffer, final StringBuilder lexeme, final char symbol,
                      final String type, final StringBuilder name) {
        this.lexeme = lexeme;
        this.symbol = symbol;
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean execute() {
        lexeme.append(symbol);
        name.append(type);
        return false;
    }
}
