package it.sevenbits.formatter.Lexer;

import it.sevenbits.formatter.Reader.IReader;
import it.sevenbits.formatter.sm.LexerSM.LexerSM;

/**
 * Default factory which return lexer which works with State Machine
 */
public class LexerSMFactory implements ILexerFactory {
    @Override
    public ILexer createLexer(final IReader reader) {
        return new LexerSM(reader);
    }
}
