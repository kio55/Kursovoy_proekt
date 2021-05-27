package it.sevenbits.formatter.sm.FormatterSM.FormatterCommands;

import it.sevenbits.formatter.Exceptions.StreamException;
import it.sevenbits.formatter.Lexer.IToken;
import it.sevenbits.formatter.Writer.IWriter;

/**
 * add word
 */
public class Symbol implements IFormatterCommand {
    private final IToken curToken;
    private final IWriter writer;

    /**
     * default constructor
     * @param curToken current token
     * @param writer where we will writing result
     */
    public Symbol(final IToken curToken, final IWriter writer) {
        this.curToken = curToken;
        this.writer = writer;
    }

    @Override
    public void execute() throws StreamException {
        for (int i = 0; i < curToken.getLexeme().length(); i++) {
            writer.write(curToken.getLexeme().charAt(i));
        }
    }
}
