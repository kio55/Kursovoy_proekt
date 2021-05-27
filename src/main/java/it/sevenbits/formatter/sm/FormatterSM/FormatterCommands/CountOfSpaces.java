package it.sevenbits.formatter.sm.FormatterSM.FormatterCommands;

/**
 * class which storage and calculate current count of spaces
 */
public class CountOfSpaces {
    private static final int COUNT_OF_ADDED_SPACES = 4;
    private int value = 0;

    /**
     * change current count of spaces
     */
    public void addValue() {
        value += COUNT_OF_ADDED_SPACES;
    }

    /**
     * change current count of spaces
     */
    public void removeValue() {
        value -= COUNT_OF_ADDED_SPACES;
    }

    public int getValue() {
        return value;
    }
}
