package it.sevenbits.formatter.sm.FormatterSM;

import it.sevenbits.formatter.sm.State;

/**
 * makes transfers based on received tokens
 */
public final class FormatterStateTransition {
    private final FormatterStateMap stateMap;

    public FormatterStateMap getStateMap() {
        return stateMap;
    }

    /**
     * Default constructor
     */
    public FormatterStateTransition() {
        this.stateMap = new FormatterStateMap();
    }

    /**
     * return next state of the state machine
     *
     * @param state current state
     * @param type  type of current token
     * @return next state
     */
    public State nextState(final State state, final String type) {
        return stateMap.getNextState(state, type);
    }

    public State getStartState() {
        return this.stateMap.getStartState();
    }
}
