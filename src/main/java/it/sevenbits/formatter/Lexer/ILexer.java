package it.sevenbits.formatter.Lexer;

import it.sevenbits.formatter.Exceptions.StreamException;

/**
 * Interface for create tokens from read chars
 */
public interface ILexer {
    /**
     * checks whether the token can be read
     *
     * @return true if token can be read
     */
    boolean hasMoreTokens();

    /**
     * read token
     *
     * @return token
     * @throws StreamException if reader errors
     */
    IToken readTokens() throws StreamException;
}
