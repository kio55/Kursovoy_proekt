package it.sevenbits.formatter.Formatter;

import it.sevenbits.formatter.Lexer.ILexer;
import it.sevenbits.formatter.Lexer.ILexerFactory;
import it.sevenbits.formatter.Lexer.IToken;
import it.sevenbits.formatter.Lexer.Token;
import it.sevenbits.formatter.Reader.IReader;
import it.sevenbits.formatter.Writer.IWriter;
import it.sevenbits.formatter.Exceptions.StreamException;

/**
 * formatting code class
 */
public class Formatter implements IFormatter {
    private final int countOfAddSpaces = 4;
    private final ILexerFactory lexerFactory;

    /**
     * default constructor
     * @param lexerFactory input lexer factory
     */
    public Formatter(final ILexerFactory lexerFactory) {
        this.lexerFactory = lexerFactory;
    }

    private void addSpaces(final int count, final IWriter writer) throws StreamException {
        for (int i = 0; i < count; i++) {
            writer.write(' ');
        }
    }

    private void addWord(final String str, final IWriter writer) throws StreamException {
        for (int i = 0; i < str.length(); i++) {
            writer.write(str.charAt(i));
        }
    }

    /**
     * a method of formatting code
     *
     * @param reader incoming characters
     * @param writer the output symbols
     * @throws StreamException thrown when an error occurs, the stream to write or read
     */
    public void format(final IReader reader, final IWriter writer) throws StreamException {
        ILexer lexer = lexerFactory.createLexer(reader);
        int countOfSpaces = 0;
        IToken prevToken = new Token(null, null);
        if (lexer.hasMoreTokens()) {
            prevToken = lexer.readTokens();
        }
        while (lexer.hasMoreTokens()) {
            StringBuilder addString = new StringBuilder();
            IToken token = lexer.readTokens();
            switch (prevToken.getName()) {
                case "opening curly brace":
                    addString.append(prevToken.getLexeme()).append('\n');
                    if (!token.getName().equals("closing curly brace")) {
                        countOfSpaces += countOfAddSpaces;
                    }
                    addWord(addString.toString(), writer);
                    addSpaces(countOfSpaces, writer);
                    break;
                case "closing curly brace":
                    addString.append(prevToken.getLexeme()).append('\n');
                    if (token.getName().equals("closing curly brace")) {
                        countOfSpaces -= countOfAddSpaces;
                    }
                    addWord(addString.toString(), writer);
                    addSpaces(countOfSpaces, writer);
                    break;
                case "opening brace":
                case "opening square bracket":
                case "string":
                    addString.append(prevToken.getLexeme());
                    addWord(addString.toString(), writer);
                    break;
                case "closing brace":
                case "closing square bracket":
                case "comma":
                    if (!token.getName().equals("semicolon") && !token.getName().equals("closing brace")) {
                        addString.append(prevToken.getLexeme()).append(" ");
                    } else {
                        addString.append(prevToken.getLexeme());
                    }
                    addWord(addString.toString(), writer);
                    break;
                case "semicolon":
                    addString.append(prevToken.getLexeme()).append('\n');
                    addWord(addString.toString(), writer);
                    if (token.getName().equals("closing curly brace")) {
                        countOfSpaces -= countOfAddSpaces;
                    }
                    addSpaces(countOfSpaces, writer);
                    break;
                case "word":
                    addString.append(prevToken.getLexeme());
                    if (!token.getName().equals("comma")
                            && !token.getName().equals("semicolon")
                            && !token.getName().equals("opening brace")
                            && !token.getName().equals("opening square bracket")
                            && !token.getName().equals("semicolon")
                            && !token.getName().equals("closing brace")
                            && !token.getName().equals("closing square bracket")) {
                        addString.append(" ");
                    }
                    addWord(addString.toString(), writer);
                    break;
                case "if":
                case "while":
                    addString.append(prevToken.getLexeme()).append(" ");
                    addWord(addString.toString(), writer);
                default:

            }
            prevToken = token;
        }
        writer.write('}');
    }
}
