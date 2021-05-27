package it.sevenbits.formatter.sm.FormatterSM.FormatterCommands;

import it.sevenbits.formatter.Exceptions.StreamException;
import it.sevenbits.formatter.Lexer.IToken;
import it.sevenbits.formatter.Writer.IWriter;

/**
 * add word/symbol and line break
 */
public class SymbolLineBreak implements IFormatterCommand {
    private final IToken curToken;
    private final IWriter writer;
    /**
     * default constructor
     * @param curToken current word
     * @param writer where we write current word
     */
    public SymbolLineBreak(final IToken curToken, final IWriter writer) {
        this.curToken = curToken;
        this.writer = writer;
    }

    @Override
    public void execute() throws StreamException {
        for (int i = 0; i < curToken.getLexeme().length(); i++) {
            writer.write(curToken.getLexeme().charAt(i));
        }
        writer.write('\n');
    }
}
