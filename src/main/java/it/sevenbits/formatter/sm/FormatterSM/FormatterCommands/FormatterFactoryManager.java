package it.sevenbits.formatter.sm.FormatterSM.FormatterCommands;

import it.sevenbits.formatter.sm.FormatterSM.FormatterStateMap;
import it.sevenbits.formatter.sm.FormatterSM.FormatterStateTransition;
import it.sevenbits.formatter.sm.Pair;
import it.sevenbits.formatter.sm.State;

import java.util.HashMap;
import java.util.Map;

/**
 * Selects a command based on the current state of the machine and the input signal
 */
public class FormatterFactoryManager {
    private final Map<Pair<State, String>, IFormatterCommandFactory> states;

    /**
     * Default constructor
     * @param formatterStateTransition device storing the transition table of the machine
     */
    public FormatterFactoryManager(final FormatterStateTransition formatterStateTransition) {
        FormatterStateMap stateMap = formatterStateTransition.getStateMap();
        State defaultState = stateMap.getDefaultState();
        State wordState = stateMap.getWordState();
        State cycleState = stateMap.getCycleState();
        State symbolState = stateMap.getSymbolState();
        State openBracketState = stateMap.getOpenBracketState();
        State closeBracketState = stateMap.getCloseBracketState();
        State semicolonState = stateMap.getSemicolonState();
        State firstBracketInCycle = stateMap.getFirstBracketInCycleState();
        State openBraceState = stateMap.getOpenBraceState();

        states = new HashMap<>();

        states.put(new Pair<>(defaultState, "opening curly brace"), new SymbolLineBreakFactory());
        states.put(new Pair<>(defaultState, "closing curly brace"), new SymbolLineBreakFactory());
        states.put(new Pair<>(defaultState, "word"), new SymbolFactory());
        states.put(new Pair<>(defaultState, "if"), new SymbolFactory());
        states.put(new Pair<>(defaultState, "while"), new SymbolFactory());
        states.put(new Pair<>(defaultState, "for"), new SymbolFactory());

        states.put(new Pair<>(wordState, "word"), new SpaceSymbolFactory());
        states.put(new Pair<>(wordState, "opening curly brace"), new SymbolLineBreakSpacesUpperFactory());
        states.put(new Pair<>(wordState, "opening brace"), new SymbolFactory());
        states.put(new Pair<>(wordState, "opening square bracket"), new SymbolFactory());
        states.put(new Pair<>(wordState, "closing square bracket"), new SymbolFactory());
        states.put(new Pair<>(wordState, "closing brace"), new SymbolFactory());
        states.put(new Pair<>(wordState, "closing curly brace"), new SymbolFactory());
        states.put(new Pair<>(wordState, "comma"), new SymbolFactory());
        states.put(new Pair<>(wordState, "semicolon"), new SymbolLineBreakFactory());
        states.put(new Pair<>(wordState, "slash"), new SpaceSymbolFactory());
        states.put(new Pair<>(wordState, "star"), new SpaceSymbolFactory());

        states.put(new Pair<>(cycleState, "opening brace"), new SpaceSymbolFactory());
        states.put(new Pair<>(cycleState, "word"), new SpaceSymbolFactory());
        states.put(new Pair<>(cycleState, "semicolon"), new SymbolFactory());
        states.put(new Pair<>(cycleState, "closing brace"), new SymbolFactory());

        states.put(new Pair<>(firstBracketInCycle, "word"), new SymbolFactory());


        states.put(new Pair<>(symbolState, "word"), new SpaceSymbolFactory());
        states.put(new Pair<>(symbolState, "opening brace"), new SymbolFactory());
        states.put(new Pair<>(symbolState, "closing brace"), new SymbolFactory());
        states.put(new Pair<>(symbolState, "opening curly brace"), new SymbolLineBreakSpacesUpperFactory());
        states.put(new Pair<>(symbolState, "closing curly brace"), new SpacesSymbolLineBreakLowerFactory());
        states.put(new Pair<>(symbolState, "opening square bracket"), new SymbolFactory());
        states.put(new Pair<>(symbolState, "closing square bracket"), new SymbolFactory());
        states.put(new Pair<>(symbolState, "comma"), new SymbolSpaceFactory());
        states.put(new Pair<>(symbolState, "semicolon"), new SymbolLineBreakFactory());

        states.put(new Pair<>(openBracketState, "word"), new SpacesSymbolFactory());
        states.put(new Pair<>(openBracketState, "opening curly brace"), new SpacesSymbolLineBreakUpperFactory());
        states.put(new Pair<>(openBracketState, "closing curly brace"), new SpacesSymbolLineBreakFactory());
        states.put(new Pair<>(openBracketState, "if"), new SpacesSymbolFactory());
        states.put(new Pair<>(openBracketState, "while"), new SpacesSymbolFactory());
        states.put(new Pair<>(openBracketState, "for"), new SpacesSymbolFactory());

        states.put(new Pair<>(closeBracketState, "word"), new SpacesSymbolFactory());
        states.put(new Pair<>(closeBracketState, "opening curly brace"), new SpacesSymbolLineBreakUpperFactory());
        states.put(new Pair<>(closeBracketState, "closing curly brace"), new SymbolLineBreakSpacesLowerFactory());
        states.put(new Pair<>(closeBracketState, "if"), new SpacesSymbolFactory());
        states.put(new Pair<>(closeBracketState, "while"), new SpacesSymbolFactory());
        states.put(new Pair<>(closeBracketState, "for"), new SpacesSymbolFactory());

        states.put(new Pair<>(openBraceState, "word"), new SymbolFactory());
        states.put(new Pair<>(openBraceState, "opening brace"), new SymbolFactory());
        states.put(new Pair<>(openBraceState, "closing brace"), new SymbolFactory());
        states.put(new Pair<>(openBraceState, "opening curly brace"), new SymbolLineBreakSpacesUpperFactory());
        states.put(new Pair<>(openBraceState, "closing curly brace"), new SpacesSymbolLineBreakLowerFactory());
        states.put(new Pair<>(openBraceState, "opening square bracket"), new SymbolFactory());
        states.put(new Pair<>(openBraceState, "closing square bracket"), new SymbolFactory());
        states.put(new Pair<>(openBraceState, "comma"), new SymbolSpaceFactory());
        states.put(new Pair<>(openBraceState, "semicolon"), new SymbolLineBreakFactory());

        states.put(new Pair<>(semicolonState, "word"), new SpacesSymbolFactory());
        states.put(new Pair<>(semicolonState, "opening curly brace"), new SpacesSymbolLineBreakUpperFactory());
        states.put(new Pair<>(semicolonState, "closing curly brace"), new SymbolLineBreakSpacesLowerFactory());
        states.put(new Pair<>(semicolonState, "if"), new SpacesSymbolFactory());
        states.put(new Pair<>(semicolonState, "while"), new SpacesSymbolFactory());
        states.put(new Pair<>(semicolonState, "for"), new SpacesSymbolFactory());

        states.put(new Pair<>(defaultState, "comment"), new WriteCommentWithLineBreakFactory());
        states.put(new Pair<>(semicolonState, "comment"), new WriteCommentWithLineBreakFactory());
        states.put(new Pair<>(openBracketState, "comment"), new WriteCommentWithLineBreakFactory());
        states.put(new Pair<>(closeBracketState, "comment"), new WriteCommentWithLineBreakFactory());
    }

    /**
     * Return Factory of needed command
     * @param state current state
     * @param type current type of token
     * @return factory
     */
    public IFormatterCommandFactory getFactory(final State state, final String type) {
        return states.get(new Pair<>(state, type));
    }
}
