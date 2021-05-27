package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

/**
 * factory for the commands
 */
public interface ICommandFactory {
    /**
     * return command
     *
     * @param buffer buffer with special symbol
     * @param lexeme current lexeme
     * @param symbol current symbol
     * @param type   type of current symbol
     * @param name   name of lexeme
     * @return command
     */
    ICommand getCommand(StringBuilder buffer, StringBuilder lexeme, char symbol, String type, StringBuilder name);
}
