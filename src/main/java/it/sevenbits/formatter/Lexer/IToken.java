package it.sevenbits.formatter.Lexer;

/**
 * Interface for tokens
 */
public interface IToken {
    /**
     * Get name of the token
     * @return name of the token
     */
    String getName();

    /**
     * Get lexeme of the token
     * @return lexeme
     */
    String getLexeme();
}
