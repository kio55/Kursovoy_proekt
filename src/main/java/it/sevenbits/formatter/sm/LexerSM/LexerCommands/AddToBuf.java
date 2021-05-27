package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

import java.util.Vector;

/**
 * save current word and fill buffer
 */
public class AddToBuf implements ICommand {
    private final StringBuilder buffer;
    private final StringBuilder lexeme;
    private final char symbol;
    private final StringBuilder name;
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
    public AddToBuf(final StringBuilder buffer, final StringBuilder lexeme, final char symbol, final String type,
                    final StringBuilder name) {
        this.lexeme = lexeme;
        this.symbol = symbol;
        this.name = name;
        this.buffer = buffer;
        keys.add("if");
        keys.add("for");
        keys.add("while");
    }

    @Override
    public boolean execute() {
        name.setLength(0);
        if (keys.contains(lexeme.toString())) {
            name.append(lexeme);
        } else {
            name.append("word");
        }
        buffer.append(symbol);
        return false;
    }
}
