package it.sevenbits.formatter.Lexer;

import it.sevenbits.formatter.Reader.IReader;

/**
 * Default interface for lexer factory
 */
public interface ILexerFactory {
    /**
     * create lexer
     *
     * @param reader input reader
     * @return lexer
     */
    ILexer createLexer(IReader reader);
}
