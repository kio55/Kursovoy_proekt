package it.sevenbits.formatter.sm.LexerSM;

import it.sevenbits.formatter.Exceptions.StreamException;
import it.sevenbits.formatter.Lexer.ILexer;
import it.sevenbits.formatter.Lexer.IToken;
import it.sevenbits.formatter.Lexer.Token;
import it.sevenbits.formatter.Reader.IReader;
import it.sevenbits.formatter.sm.LexerSM.LexerCommands.FactoryManager;
import it.sevenbits.formatter.sm.LexerSM.LexerCommands.ICommand;
import it.sevenbits.formatter.sm.LexerSM.LexerCommands.ICommandFactory;
import it.sevenbits.formatter.sm.State;

import java.util.HashMap;

/**
 * The main part of the machine accepts symbols as input and changes states, as a result of the work we get a lexeme
 */
public class LexerSM implements ILexer {
    private final IReader reader;
    private final StringBuilder buffer = new StringBuilder();
    private final HashMap<Character, String> symbols = new HashMap<>();
    private final LexerStateTransition lexerStateTransition;

    /**
     * default constructor
     * @param reader where we take symbols
     */
    public LexerSM(final IReader reader) {
        this.reader = reader;
        symbols.put('{', "opening curly brace");
        symbols.put('}', "closing curly brace");
        symbols.put('(', "opening brace");
        symbols.put(')', "closing brace");
        symbols.put('[', "opening square bracket");
        symbols.put(']', "closing square bracket");
        symbols.put(',', "comma");
        symbols.put(';', "semicolon");
        symbols.put('\n', "line break");
        symbols.put('/', "slash");
        symbols.put('*', "star");
        symbols.put(' ', "space");
        symbols.put('"', "quotes");
        lexerStateTransition = new LexerStateTransition();
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
        StringBuilder name = new StringBuilder();
        State currentState = lexerStateTransition.getStartState();
        FactoryManager factoryManager = new FactoryManager(lexerStateTransition);
        StringBuilder lexeme = new StringBuilder();
        boolean end = true;
        while (reader.hasNext() && buffer.length() == 0 && end) {
            char curSymbol = reader.read();
            ICommandFactory commandFactory = factoryManager.getFactory(currentState, symbols.getOrDefault(curSymbol, "symbol"));
            ICommand command = commandFactory.getCommand(buffer, lexeme, curSymbol, symbols.getOrDefault(curSymbol, "symbol"), name);
            end = command.execute();
            currentState = lexerStateTransition.nextState(currentState, symbols.getOrDefault(curSymbol, "symbol"));
        }

        if (buffer.length() > 0 && end) {
            lexeme.append(buffer);
            name.append(symbols.getOrDefault(buffer.toString().charAt(0), "symbol"));
            buffer.setLength(0);
        }

        return new Token(name.toString(), lexeme.toString());
    }
}
