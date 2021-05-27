package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * set name of the comment
 */
public class GiveName implements ICommand {
    private final char symbol;
    private StringBuilder name;

    /**
     * default constructor
     *
     * @param buffer buffer with special symbol
     * @param lexeme current lexeme
     * @param symbol current symbol
     * @param type   type of current symbol
     * @param name   name of lexeme
     */
    public GiveName(final StringBuilder buffer, final StringBuilder lexeme, final char symbol,
                    final String type, final StringBuilder name) {
        this.symbol = symbol;
        this.name = name;
    }

    @Override
    public boolean execute() {
        name.setLength(0);
        if (symbol == '/') {
            name.append("comment");
        } else {
            name.append("multiline_comment");
        }
        return true;
    }
}
