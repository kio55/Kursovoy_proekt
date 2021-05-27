package it.sevenbits.formatter.sm.LexerSM;

import it.sevenbits.formatter.sm.Pair;
import it.sevenbits.formatter.sm.State;

import java.util.HashMap;
import java.util.Map;

/**
 * Class with automata transition table and states of the machine
 */
public class LexerStateMap {
    private final State defaultState = new State("IGNORE");

    private final State suspicion = new State("COMMENT_SUSPICION");
    private final State wordRead = new State("READ_WORD");
    private final State readComment = new State("READ_ONE_LINE_COMMENT");
    private final State readBigComment = new State("READ_MULTILINE_COMMENT");
    private final State bigCommentSuspicion = new State("STAR_WHILE_READ_MULTILINE_COMMENT");
    private final State symbolRead = new State("READ_SYMBOL");
    private final State quotesReader = new State("READ_TEXT_IN_QUOTES");
    private final Map<Pair<State, String>, State> states;

    public State getDefaultState() {
        return defaultState;
    }

    public State getSuspicion() {
        return suspicion;
    }

    public State getWordRead() {
        return wordRead;
    }

    public State getReadComment() {
        return readComment;
    }

    public State getReadBigComment() {
        return readBigComment;
    }

    public State getBigCommentSuspicion() {
        return bigCommentSuspicion;
    }

    public State getSymbolRead() {
        return symbolRead;
    }

    public State getQuotesReader() {
        return quotesReader;
    }

    /**
     * Default constructor
     */
    public LexerStateMap() {
        this.states = new HashMap<>();
        states.put(new Pair<>(defaultState, "space"), defaultState);
        states.put(new Pair<>(defaultState, "line break"), defaultState);

        states.put(new Pair<>(defaultState, "slash"), suspicion);

        states.put(new Pair<>(defaultState, "symbol"), wordRead);
        states.put(new Pair<>(defaultState, "star"), wordRead);

        states.put(new Pair<>(defaultState, "quotes"), quotesReader);
        states.put(new Pair<>(quotesReader, "quotes"), defaultState);
        states.put(new Pair<>(quotesReader, "slash"), quotesReader);
        states.put(new Pair<>(quotesReader, "opening curly brace"), quotesReader);
        states.put(new Pair<>(quotesReader, "closing curly brace"), quotesReader);
        states.put(new Pair<>(quotesReader, "opening brace"), quotesReader);
        states.put(new Pair<>(quotesReader, "closing brace"), quotesReader);
        states.put(new Pair<>(quotesReader, "opening square bracket"), quotesReader);
        states.put(new Pair<>(quotesReader, "closing square bracket"), quotesReader);
        states.put(new Pair<>(quotesReader, "comma"), quotesReader);
        states.put(new Pair<>(quotesReader, "semicolon"), quotesReader);
        states.put(new Pair<>(quotesReader, "space"), quotesReader);
        states.put(new Pair<>(quotesReader, "line break"), quotesReader);
        states.put(new Pair<>(quotesReader, "star"), quotesReader);
        states.put(new Pair<>(quotesReader, "symbol"), quotesReader);


        states.put(new Pair<>(defaultState, "opening curly brace"), symbolRead);
        states.put(new Pair<>(defaultState, "closing curly brace"), symbolRead);
        states.put(new Pair<>(defaultState, "opening brace"), symbolRead);
        states.put(new Pair<>(defaultState, "closing brace"), symbolRead);
        states.put(new Pair<>(defaultState, "opening square bracket"), symbolRead);
        states.put(new Pair<>(defaultState, "closing square bracket"), symbolRead);
        states.put(new Pair<>(defaultState, "comma"), symbolRead);
        states.put(new Pair<>(defaultState, "semicolon"), symbolRead);

        states.put(new Pair<>(wordRead, "space"), defaultState);
        states.put(new Pair<>(wordRead, "line break"), defaultState);

        states.put(new Pair<>(wordRead, "symbol"), wordRead);

        states.put(new Pair<>(suspicion, "slash"), readComment);
        states.put(new Pair<>(suspicion, "star"), readBigComment);

        states.put(new Pair<>(readComment, "slash"), readComment);
        states.put(new Pair<>(readComment, "opening curly brace"), readComment);
        states.put(new Pair<>(readComment, "closing curly brace"), readComment);
        states.put(new Pair<>(readComment, "opening brace"), readComment);
        states.put(new Pair<>(readComment, "closing brace"), readComment);
        states.put(new Pair<>(readComment, "opening square bracket"), readComment);
        states.put(new Pair<>(readComment, "closing square bracket"), readComment);
        states.put(new Pair<>(readComment, "comma"), readComment);
        states.put(new Pair<>(readComment, "semicolon"), readComment);
        states.put(new Pair<>(readComment, "space"), readComment);
        states.put(new Pair<>(readComment, "line break"), defaultState);
        states.put(new Pair<>(readComment, "star"), readComment);
        states.put(new Pair<>(readComment, "symbol"), readComment);

        states.put(new Pair<>(readBigComment, "slash"), readBigComment);
        states.put(new Pair<>(readBigComment, "opening curly brace"), readBigComment);
        states.put(new Pair<>(readBigComment, "closing curly brace"), readBigComment);
        states.put(new Pair<>(readBigComment, "opening brace"), readBigComment);
        states.put(new Pair<>(readBigComment, "closing brace"), readBigComment);
        states.put(new Pair<>(readBigComment, "opening square bracket"), readBigComment);
        states.put(new Pair<>(readBigComment, "closing square bracket"), readBigComment);
        states.put(new Pair<>(readBigComment, "comma"), readBigComment);
        states.put(new Pair<>(readBigComment, "semicolon"), readBigComment);
        states.put(new Pair<>(readBigComment, "space"), readBigComment);
        states.put(new Pair<>(readBigComment, "line break"), readBigComment);
        states.put(new Pair<>(readBigComment, "star"), bigCommentSuspicion);
        states.put(new Pair<>(readBigComment, "symbol"), readBigComment);

        states.put(new Pair<>(bigCommentSuspicion, "slash"), defaultState);
        states.put(new Pair<>(bigCommentSuspicion, "slash"), readBigComment);
        states.put(new Pair<>(bigCommentSuspicion, "opening curly brace"), readBigComment);
        states.put(new Pair<>(bigCommentSuspicion, "closing curly brace"), readBigComment);
        states.put(new Pair<>(bigCommentSuspicion, "opening brace"), readBigComment);
        states.put(new Pair<>(bigCommentSuspicion, "closing brace"), readBigComment);
        states.put(new Pair<>(bigCommentSuspicion, "opening square bracket"), readBigComment);
        states.put(new Pair<>(bigCommentSuspicion, "closing square bracket"), readBigComment);
        states.put(new Pair<>(bigCommentSuspicion, "comma"), readBigComment);
        states.put(new Pair<>(bigCommentSuspicion, "semicolon"), readBigComment);
        states.put(new Pair<>(bigCommentSuspicion, "space"), readBigComment);
        states.put(new Pair<>(bigCommentSuspicion, "line break"), readBigComment);
        states.put(new Pair<>(bigCommentSuspicion, "symbol"), readBigComment);

    }

    public State getStartState() {
        return defaultState;
    }

    /**
     * Tries to return the state of the machine, depending on the current and input signal; on failure, returns the standard state
     *
     * @param state  current state
     * @param signal input token type
     * @return new state of the machine
     */
    public State getNextState(final State state, final String signal) {
        return states.getOrDefault(new Pair<>(state, signal), defaultState);
    }
}
