package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * stop state machine
 */
public class Exit implements ICommand {
    /**
     * default constructor
     */
    public Exit() {
    }

    @Override
    public boolean execute() {
        return false;
    }
}