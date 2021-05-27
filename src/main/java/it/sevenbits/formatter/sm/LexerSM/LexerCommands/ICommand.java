package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * main lexer command interface
 */
public interface ICommand {
    /**
     * make actions with input symbol
     *
     * @return stop cycle or not
     */
    default boolean execute() {
        return true;
    }
}

