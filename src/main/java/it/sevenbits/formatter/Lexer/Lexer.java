package it.sevenbits.formatter.Lexer;

import it.sevenbits.formatter.Exceptions.StreamException;
import it.sevenbits.formatter.Reader.IReader;

import java.util.HashMap;

/**
 * Default Lexer which make tokens from input chars
 */
public class Lexer implements ILexer {
    private final IReader reader;
    private final StringBuilder buffer = new StringBuilder();
    private final HashMap<Character, String> symbols = new HashMap<>();

    /**
     * default constructor
     *
     * @param reader input reader
     */
    public Lexer(final IReader reader) {
        this.reader = reader;
        symbols.put('{', "opening curly brace");
        symbols.put('}', "closing curly brace");
        symbols.put('(', "opening brace");
        symbols.put(')', "closing brace");
        symbols.put('[', "opening square bracket");
        symbols.put(']', "closing square bracket");
        symbols.put(',', "comma");
        symbols.put(';', "semicolon");
    }


    @Override
    public boolean hasMoreTokens() {
        try {
            return reader.hasNext() || buffer.length() != 0;
        } catch (StreamException e) {
            System.out.println("Error");
            return false;
        }

    }

    @Override
    public IToken readTokens() throws StreamException {
        String name;
        StringBuilder lexeme = new StringBuilder();
        boolean literal = false;
        while (reader.hasNext() && buffer.length() == 0) {
            char curSymbol = reader.read();
            if (curSymbol == '"') {
                literal = !literal;
            }
            if (!literal) {
                if (symbols.containsKey(curSymbol)) {
                    if (lexeme.length() == 0) {
                        lexeme.append(curSymbol);
                    } else {
                        buffer.append(curSymbol);
                    }
                    break;
                }
                if (curSymbol == ' ' || curSymbol == '\n') {
                    if (lexeme.length() == 0) {
                        continue;
                    } else {
                        break;
                    }
                }
            }
            lexeme.append(curSymbol);

        }
        if (buffer.length() != 0 && lexeme.length() == 0) {
            lexeme.append(buffer);
            buffer.deleteCharAt(0);
        }
        name = symbols.getOrDefault(lexeme.charAt(0), "text");
        if (lexeme.charAt(0) == '"') {
            name = "string";
        }
        if (lexeme.toString().equals("if")) {
            name = "if";
        }
        if (lexeme.toString().equals("while")) {
            name = "while";
        }

        return new Token(name, lexeme.toString());
    }
}
