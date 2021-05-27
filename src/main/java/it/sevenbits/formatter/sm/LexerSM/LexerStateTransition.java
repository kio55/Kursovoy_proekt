package it.sevenbits.formatter.sm.LexerSM;

import it.sevenbits.formatter.sm.State;

/**
 * makes transfers based on received symbols
 */

public final class LexerStateTransition {
    private final LexerStateMap stateMap;

    public LexerStateMap getStateMap() {
        return stateMap;
    }

    /**
     * default constructor
     */
    public LexerStateTransition() {
        this.stateMap = new LexerStateMap();
    }

    /**
     * return next state based on current state and input signal type
     *
     * @param state current state
     * @param type  current symbol type
     * @return next state
     */
    public State nextState(final State state, final String type) {
        return stateMap.getNextState(state, type);
    }

    public State getStartState() {
        return this.stateMap.getStartState();
    }
}
