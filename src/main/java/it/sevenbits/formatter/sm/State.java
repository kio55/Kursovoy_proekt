package it.sevenbits.formatter.sm;

import java.util.Objects;

/**
 * Class for storing the state of the machine
 */

public class State {
    private final String currentState;

    /**
     * Default constructor
     * @param currentState name of current state
     */

    public State(final String currentState) {
        this.currentState = currentState;
    }

    @Override
    public String toString() {
        return currentState;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        State state = (State) o;
        return Objects.equals(currentState, state.currentState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentState);
    }
}
