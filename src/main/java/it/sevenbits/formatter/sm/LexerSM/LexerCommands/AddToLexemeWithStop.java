package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

import java.util.Vector;

/**
 * Add symbol to lexeme and stop state machine
 */
public class AddToLexemeWithStop implements ICommand {
    private final StringBuilder lexeme;
    private final char symbol;
    private StringBuilder name;
    private final Vector<String> keys = new Vector<String>();

    /**
     * default constructor
     *
     * @param buffer buffer with special symbol
     * @param lexeme current lexeme
     * @param symbol current symbol
     * @param type   type of current symbol
     * @param name   name of lexeme
     */
    public AddToLexemeWithStop(final StringBuilder buffer, final StringBuilder lexeme, final char symbol,
                               final String type, final StringBuilder name) {
        this.lexeme = lexeme;
        this.symbol = symbol;
        this.name = name;
        keys.add("if");
        keys.add("for");
        keys.add("while");
    }

    @Override
    public boolean execute() {
        lexeme.append(symbol);
        name.setLength(0);
        if (keys.contains(lexeme.toString())) {
            name.append(lexeme);
        } else {
            name.append("word");
        }
        return false;
    }
}
