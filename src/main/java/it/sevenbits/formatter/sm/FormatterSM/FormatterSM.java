package it.sevenbits.formatter.sm.FormatterSM;

import it.sevenbits.formatter.Exceptions.StreamException;
import it.sevenbits.formatter.Formatter.IFormatter;
import it.sevenbits.formatter.Lexer.ILexer;
import it.sevenbits.formatter.Lexer.ILexerFactory;
import it.sevenbits.formatter.Lexer.IToken;
import it.sevenbits.formatter.Reader.IReader;
import it.sevenbits.formatter.Writer.IWriter;
import it.sevenbits.formatter.sm.FormatterSM.FormatterCommands.CountOfSpaces;
import it.sevenbits.formatter.sm.FormatterSM.FormatterCommands.FormatterFactoryManager;
import it.sevenbits.formatter.sm.FormatterSM.FormatterCommands.IFormatterCommand;
import it.sevenbits.formatter.sm.FormatterSM.FormatterCommands.IFormatterCommandFactory;
import it.sevenbits.formatter.sm.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main part of the machine accepts tokens as input and changes states, as a result of the work we get a formatted code
 */
public class FormatterSM implements IFormatter {
    /**
     * LOGGER
     */
    static final Logger LOGGER = LoggerFactory.getLogger(FormatterSM.class);
    private final ILexerFactory lexerFactory;
    @SuppressWarnings("checkstyle:MemberName")
    private final FormatterStateTransition formatterStateTransition;

    /**
     * Default constructor
     *
     * @param lexerFactory lexer with which the formatter works
     */
    public FormatterSM(final ILexerFactory lexerFactory) {
        this.lexerFactory = lexerFactory;
        formatterStateTransition = new FormatterStateTransition();
    }

    @Override
    public void format(final IReader reader, final IWriter writer) throws StreamException {
        ILexer lexer = lexerFactory.createLexer(reader);
        State currentState = formatterStateTransition.getStartState();
        FormatterFactoryManager factoryManager = new FormatterFactoryManager(formatterStateTransition);
        CountOfSpaces countOfSpaces = new CountOfSpaces();
        while (lexer.hasMoreTokens()) {
            IToken token = lexer.readTokens();
            if (token.getLexeme().equals("")) {
                break;
            }
            LOGGER.info("Current token - " + token.getLexeme() + " " + token.getName() + "Current state - " + currentState);
            IFormatterCommandFactory commandFactory = factoryManager.getFactory(currentState, token.getName());
            IFormatterCommand command = commandFactory.getCommand(countOfSpaces, token, writer);
            command.execute();
            currentState = formatterStateTransition.nextState(currentState, token.getName());
        }
    }
}
