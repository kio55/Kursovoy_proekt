package it.sevenbits.formatter.Lexer;

import it.sevenbits.formatter.Exceptions.StreamException;
import it.sevenbits.formatter.Reader.IReader;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LexerFactoryTest {

    @Test
    public void createLexer() throws StreamException {
        IReader mockReader = mock(IReader.class);
        when(mockReader.read()).thenReturn('a');
        when(mockReader.hasNext()).thenReturn(true,false);
        LexerFactory lexerFactory = new LexerFactory();
        ILexer lexer = lexerFactory.createLexer(mockReader);
        assertEquals("a",lexer.readTokens().getLexeme());
    }
}