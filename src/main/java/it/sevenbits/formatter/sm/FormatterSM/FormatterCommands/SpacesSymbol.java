package it.sevenbits.formatter.sm.FormatterSM.FormatterCommands;

import it.sevenbits.formatter.Exceptions.StreamException;
import it.sevenbits.formatter.Lexer.IToken;
import it.sevenbits.formatter.Writer.IWriter;

/**
 * Write spaces and after write word
 */
public class SpacesSymbol implements IFormatterCommand {
    private final CountOfSpaces countOfSpaces;
    private final IToken curToken;
    private final IWriter writer;

    /**
     * default constructor
     * @param countOfSpaces count of added spaces
     * @param curToken current word
     * @param writer where we write current word
     */
    public SpacesSymbol(final CountOfSpaces countOfSpaces, final IToken curToken, final IWriter writer) {
        this.countOfSpaces = countOfSpaces;
        this.curToken = curToken;
        this.writer = writer;
    }

    @Override
    public void execute() throws StreamException {
        for (int i = 0; i < countOfSpaces.getValue(); i++) {
            writer.write(' ');
        }
        for (int i = 0; i < curToken.getLexeme().length(); i++) {
            writer.write(curToken.getLexeme().charAt(i));
        }
    }
}
