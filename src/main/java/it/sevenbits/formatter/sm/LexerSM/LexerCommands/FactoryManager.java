package it.sevenbits.formatter.sm.LexerSM.LexerCommands;

import it.sevenbits.formatter.sm.LexerSM.LexerStateMap;
import it.sevenbits.formatter.sm.Pair;
import it.sevenbits.formatter.sm.State;
import it.sevenbits.formatter.sm.LexerSM.LexerStateTransition;

import java.util.HashMap;
import java.util.Map;

/**
 * Class which chose next command
 */
public class FactoryManager {
    private final Map<Pair<State, String>, ICommandFactory> states;

    /**
     * default constructor
     *
     * @param lexerStateTransition current StateMap
     */
    public FactoryManager(final LexerStateTransition lexerStateTransition) {
        LexerStateMap stateMap = lexerStateTransition.getStateMap();
        State defaultState = stateMap.getDefaultState();
        State suspicion = stateMap.getSuspicion();
        State wordRead = stateMap.getWordRead();
        State quotesReader = stateMap.getQuotesReader();
        State readComment = stateMap.getReadComment();
        State readBigComment = stateMap.getReadBigComment();
        State bigCommentSuspicion = stateMap.getBigCommentSuspicion();

        states = new HashMap<>();

        states.put(new Pair<>(defaultState, "space"), new IgnoreCommandFactory());
        states.put(new Pair<>(defaultState, "line break"), new IgnoreCommandFactory());

        states.put(new Pair<>(defaultState, "slash"), new IgnoreCommandFactory());

        states.put(new Pair<>(defaultState, "symbol"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(defaultState, "star"), new AddToLexemeCommandFactory());

        states.put(new Pair<>(defaultState, "quotes"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "slash"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "opening curly brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "closing curly brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "opening brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "closing brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "opening square bracket"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "closing square bracket"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "comma"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "semicolon"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "star"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "space"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "line break"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "symbol"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(quotesReader, "quotes"), new AddToLexemeWithStopFactory());

        states.put(new Pair<>(defaultState, "opening curly brace"), new ReadSymbolCommandFactory());
        states.put(new Pair<>(defaultState, "closing curly brace"), new ReadSymbolCommandFactory());
        states.put(new Pair<>(defaultState, "opening brace"), new ReadSymbolCommandFactory());
        states.put(new Pair<>(defaultState, "closing brace"), new ReadSymbolCommandFactory());
        states.put(new Pair<>(defaultState, "opening square bracket"), new ReadSymbolCommandFactory());
        states.put(new Pair<>(defaultState, "closing square bracket"), new ReadSymbolCommandFactory());
        states.put(new Pair<>(defaultState, "comma"), new ReadSymbolCommandFactory());
        states.put(new Pair<>(defaultState, "semicolon"), new ReadSymbolCommandFactory());

        states.put(new Pair<>(wordRead, "space"), new CompareCommandFactory());
        states.put(new Pair<>(wordRead, "line break"), new CompareCommandFactory());

        states.put(new Pair<>(wordRead, "symbol"), new AddToLexemeCommandFactory());

        states.put(new Pair<>(suspicion, "slash"), new GiveNameFactory());
        states.put(new Pair<>(suspicion, "star"), new GiveNameFactory());

        states.put(new Pair<>(wordRead, "slash"), new AddToBufFactory());
        states.put(new Pair<>(wordRead, "opening curly brace"), new AddToBufFactory());
        states.put(new Pair<>(wordRead, "closing curly brace"), new AddToBufFactory());
        states.put(new Pair<>(wordRead, "opening brace"), new AddToBufFactory());
        states.put(new Pair<>(wordRead, "closing brace"), new AddToBufFactory());
        states.put(new Pair<>(wordRead, "opening square bracket"), new AddToBufFactory());
        states.put(new Pair<>(wordRead, "closing square bracket"), new AddToBufFactory());
        states.put(new Pair<>(wordRead, "comma"), new AddToBufFactory());
        states.put(new Pair<>(wordRead, "semicolon"), new AddToBufFactory());
        states.put(new Pair<>(wordRead, "star"), new AddToBufFactory());

        states.put(new Pair<>(readComment, "slash"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readComment, "opening curly brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readComment, "closing curly brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readComment, "opening brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readComment, "closing brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readComment, "opening square bracket"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readComment, "closing square bracket"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readComment, "comma"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readComment, "semicolon"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readComment, "space"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readComment, "line break"), new ExitFactory());
        states.put(new Pair<>(readComment, "star"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readComment, "symbol"), new AddToLexemeCommandFactory());

        states.put(new Pair<>(readBigComment, "slash"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readBigComment, "opening curly brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readBigComment, "closing curly brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readBigComment, "opening brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readBigComment, "closing brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readBigComment, "opening square bracket"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readBigComment, "closing square bracket"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readBigComment, "comma"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readBigComment, "semicolon"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readBigComment, "space"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readBigComment, "line break"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readBigComment, "star"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(readBigComment, "symbol"), new AddToLexemeCommandFactory());

        states.put(new Pair<>(bigCommentSuspicion, "slash"), new ExitWithDelFactory());
        states.put(new Pair<>(bigCommentSuspicion, "opening curly brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(bigCommentSuspicion, "closing curly brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(bigCommentSuspicion, "opening brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(bigCommentSuspicion, "closing brace"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(bigCommentSuspicion, "opening square bracket"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(bigCommentSuspicion, "closing square bracket"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(bigCommentSuspicion, "comma"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(bigCommentSuspicion, "semicolon"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(bigCommentSuspicion, "space"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(bigCommentSuspicion, "line break"), new AddToLexemeCommandFactory());
        states.put(new Pair<>(bigCommentSuspicion, "symbol"), new AddToLexemeCommandFactory());
    }

    /**
     * return next command
     *
     * @param state current state
     * @param type  current type
     * @return command
     */
    public ICommandFactory getFactory(final State state, final String type) {
        return states.get(new Pair<>(state, type));
    }
}

