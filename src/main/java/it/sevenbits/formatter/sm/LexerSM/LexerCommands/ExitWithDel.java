package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * exit from cycle and delete last symbol in lexeme
 */
public class ExitWithDel implements ICommand {
    private final StringBuilder lexeme;

    /**
     * default constructor
     *
     * @param lexeme current lexeme
     */
    public ExitWithDel(final StringBuilder lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public boolean execute() {
        lexeme.setLength(lexeme.length() - 1);
        return false;
    }
}
