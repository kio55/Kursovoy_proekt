package it.sevenbits.formatter.sm.FormatterSM;

import it.sevenbits.formatter.sm.Pair;
import it.sevenbits.formatter.sm.State;

import java.util.HashMap;

/**
 * Class with automata transition table and states of the machine
 */

public class FormatterStateMap {
    private final State defaultState = new State("WRITE_FIRST_ELEMENT");
    private final State wordState = new State("WRITE_WORD");
    private final State cycleState = new State("WRITE_CYCLE");
    private final State semicolonState = new State("WRITE_SEMICOLON");
    private final State symbolState = new State("WRITE_SYMBOL_WITHOUT_SPACES");
    private final State openBracketState = new State("WRITE_OPEN_BRACKETS");
    private final State closeBracketState = new State("WRITE_ClOSE_BRACKETS");
    private final State firstBracketInCycleState = new State("WRITE_FIRST_CYCLE_BRACKET");
    private final State openBraceState = new State("WRITE_OPEN_BRACE");

    private final HashMap<Pair<State, String>, State> states;

    public State getDefaultState() {
        return defaultState;
    }

    public State getWordState() {
        return wordState;
    }

    public State getCycleState() {
        return cycleState;
    }

    public State getSymbolState() {
        return symbolState;
    }

    public State getOpenBracketState() {
        return openBracketState;
    }

    public State getCloseBracketState() {
        return closeBracketState;
    }

    public State getSemicolonState() {
        return semicolonState;
    }

    public State getFirstBracketInCycleState() {
        return firstBracketInCycleState;
    }

    public State getOpenBraceState() {
        return openBraceState;
    }

    /**
     * Default constructor
     */
    public FormatterStateMap() {
        this.states = new HashMap<>();
        states.put(new Pair<>(defaultState, "opening curly brace"), openBracketState);
        states.put(new Pair<>(defaultState, "closing curly brace"), closeBracketState);
        states.put(new Pair<>(defaultState, "word"), wordState);
        states.put(new Pair<>(defaultState, "if"), cycleState);
        states.put(new Pair<>(defaultState, "while"), cycleState);
        states.put(new Pair<>(defaultState, "for"), cycleState);

        states.put(new Pair<>(wordState, "word"), wordState);
        states.put(new Pair<>(wordState, "opening curly brace"), openBracketState);
        states.put(new Pair<>(wordState, "opening brace"), openBraceState);
        states.put(new Pair<>(wordState, "opening square bracket"), symbolState);
        states.put(new Pair<>(wordState, "closing square bracket"), symbolState);
        states.put(new Pair<>(wordState, "closing brace"), symbolState);
        states.put(new Pair<>(wordState, "closing curly brace"), closeBracketState);
        states.put(new Pair<>(wordState, "comma"), symbolState);
        states.put(new Pair<>(wordState, "semicolon"), semicolonState);
        states.put(new Pair<>(wordState, "slash"), wordState);
        states.put(new Pair<>(wordState, "star"), wordState);

        states.put(new Pair<>(cycleState, "opening brace"), firstBracketInCycleState);
        states.put(new Pair<>(cycleState, "word"), cycleState);
        states.put(new Pair<>(cycleState, "semicolon"), cycleState);
        states.put(new Pair<>(cycleState, "closing brace"), wordState);

        states.put(new Pair<>(firstBracketInCycleState, "word"), cycleState);

        states.put(new Pair<>(openBraceState, "word"), wordState);
        states.put(new Pair<>(openBraceState, "opening brace"), openBraceState);
        states.put(new Pair<>(openBraceState, "closing brace"), symbolState);
        states.put(new Pair<>(openBraceState, "opening curly brace"), openBracketState);
        states.put(new Pair<>(openBraceState, "closing curly brace"), closeBracketState);
        states.put(new Pair<>(openBraceState, "opening square bracket"), symbolState);
        states.put(new Pair<>(openBraceState, "closing square bracket"), symbolState);
        states.put(new Pair<>(openBraceState, "comma"), symbolState);
        states.put(new Pair<>(openBraceState, "semicolon"), semicolonState);

        states.put(new Pair<>(symbolState, "word"), wordState);
        states.put(new Pair<>(symbolState, "opening brace"), symbolState);
        states.put(new Pair<>(symbolState, "closing brace"), symbolState);
        states.put(new Pair<>(symbolState, "opening curly brace"), openBracketState);
        states.put(new Pair<>(symbolState, "closing curly brace"), closeBracketState);
        states.put(new Pair<>(symbolState, "opening square bracket"), symbolState);
        states.put(new Pair<>(symbolState, "closing square bracket"), symbolState);
        states.put(new Pair<>(symbolState, "comma"), symbolState);
        states.put(new Pair<>(symbolState, "semicolon"), semicolonState);

        states.put(new Pair<>(openBracketState, "word"), wordState);
        states.put(new Pair<>(openBracketState, "opening curly brace"), openBracketState);
        states.put(new Pair<>(openBracketState, "closing curly brace"), closeBracketState);
        states.put(new Pair<>(openBracketState, "if"), cycleState);
        states.put(new Pair<>(openBracketState, "while"), cycleState);
        states.put(new Pair<>(openBracketState, "for"), cycleState);

        states.put(new Pair<>(closeBracketState, "word"), wordState);
        states.put(new Pair<>(closeBracketState, "opening curly brace"), openBracketState);
        states.put(new Pair<>(closeBracketState, "closing curly brace"), closeBracketState);
        states.put(new Pair<>(closeBracketState, "if"), cycleState);
        states.put(new Pair<>(closeBracketState, "while"), cycleState);
        states.put(new Pair<>(closeBracketState, "for"), cycleState);

        states.put(new Pair<>(semicolonState, "word"), wordState);
        states.put(new Pair<>(semicolonState, "opening curly brace"), openBracketState);
        states.put(new Pair<>(semicolonState, "closing curly brace"), closeBracketState);
        states.put(new Pair<>(semicolonState, "if"), cycleState);
        states.put(new Pair<>(semicolonState, "while"), cycleState);
        states.put(new Pair<>(semicolonState, "for"), cycleState);

        states.put(new Pair<>(defaultState, "comment"), defaultState);
        states.put(new Pair<>(semicolonState, "comment"), semicolonState);
        states.put(new Pair<>(openBracketState, "comment"), openBracketState);
        states.put(new Pair<>(closeBracketState, "comment"), closeBracketState);

        states.put(new Pair<>(defaultState, "multiline_comment"), defaultState);
        states.put(new Pair<>(semicolonState, "multiline_comment"), semicolonState);
        states.put(new Pair<>(openBracketState, "multiline_comment"), openBracketState);
        states.put(new Pair<>(closeBracketState, "multiline_comment"), closeBracketState);
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
