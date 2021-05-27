package it.sevenbits.formatter.sm.FormatterSM.FormatterCommands;

import it.sevenbits.formatter.Lexer.IToken;
import it.sevenbits.formatter.Writer.IWriter;

/**
 * default factory for WriteCommentWithLineBreak command
 */
public class WriteCommentWithLineBreakFactory implements  IFormatterCommandFactory {
    @Override
    public IFormatterCommand getCommand(final CountOfSpaces countOfSpaces, final IToken curToken, final IWriter writer) {
        return new WriteCommentWithLineBreak(countOfSpaces, curToken, writer);
    }
}
