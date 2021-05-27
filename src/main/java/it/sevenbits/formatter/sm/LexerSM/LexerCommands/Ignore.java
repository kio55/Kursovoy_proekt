package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * ignore current symbol
 */
public class Ignore implements ICommand {
    /**
     * default constructor
     */
    public Ignore() {
    }


    @Override
    public boolean execute() {
        return true;
    }
}
