package it.sevenbits.formatter.Lexer;

import it.sevenbits.formatter.Lexer.IToken;

/**
 * Class for storage token
 */
public class Token implements IToken {
    private final String name;
    private final String lexeme;

    /**
     * default constructor
     * @param name name of token
     * @param lexeme name of lexeme
     */
    public Token(final String name, final String lexeme) {
        this.name = name;
        this.lexeme = lexeme;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLexeme() {
        return lexeme;
    }

}
