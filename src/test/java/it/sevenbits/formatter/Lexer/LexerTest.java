package it.sevenbits.formatter.Lexer;

import it.sevenbits.formatter.Exceptions.StreamException;
import it.sevenbits.formatter.Reader.IReader;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LexerTest {

    @Test
    public void hasMoreTokens() throws StreamException {
        IReader mockReader = mock(IReader.class);
        when(mockReader.read()).thenReturn('p');
        when(mockReader.hasNext()).thenReturn(true);
        Lexer lexer = new Lexer(mockReader);
        assertTrue(lexer.hasMoreTokens());
    }


    @Test
    public void readTokens() throws StreamException {
        IReader mockReader = mock(IReader.class);
        when(mockReader.read()).thenReturn('p', 'u', ' ', '"', 'a', '"', ' ', '[', ']', '{', '}', '(', ')', ',', ';');
        when(mockReader.hasNext()).thenReturn(true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false);
        Lexer lexer = new Lexer(mockReader);
        assertEquals(lexer.readTokens().getName(), "text");
    }

    @Test
    public void readTokensLiteral() throws StreamException {
        IReader mockReader = mock(IReader.class);
        when(mockReader.read()).thenReturn('"', 'a', '"', ' ');
        when(mockReader.hasNext()).thenReturn(true, true, true, true, false);
        Lexer lexer = new Lexer(mockReader);
        assertEquals(lexer.readTokens().getName(), "string");
    }

    @Test
    public void readTokensBuffer() throws StreamException {
        IReader mockReader = mock(IReader.class);
        when(mockReader.read()).thenReturn('a', 'b', '(', ')', ' ');
        when(mockReader.hasNext()).thenReturn(true, true, true, true, true, false);
        Lexer lexer = new Lexer(mockReader);
        assertEquals(lexer.readTokens().getName(), "text");
        assertEquals(lexer.readTokens().getName(), "opening brace");
    }
    @Test
    public void readTokensBrace() throws StreamException {
        IReader mockReader = mock(IReader.class);
        when(mockReader.read()).thenReturn('{', '{', ' ', '}', '}');
        when(mockReader.hasNext()).thenReturn(true, true, true, true, true, false);
        Lexer lexer = new Lexer(mockReader);
        assertEquals(lexer.readTokens().getName(), "opening curly brace");
        assertEquals(lexer.readTokens().getName(), "opening curly brace");
        assertEquals(lexer.readTokens().getName(), "closing curly brace");
        assertEquals(lexer.readTokens().getName(), "closing curly brace");
    }

    @Test
    public void readTokensIf() throws StreamException {
        IReader mockReader = mock(IReader.class);
        when(mockReader.read()).thenReturn('i', 'f', ' ', ' ', ' ');
        when(mockReader.hasNext()).thenReturn(true, true, true, true, true, false);
        Lexer lexer = new Lexer(mockReader);
        assertEquals(lexer.readTokens().getName(), "if");
    }

    @Test
    public void readTokensWhile() throws StreamException {
        IReader mockReader = mock(IReader.class);
        when(mockReader.read()).thenReturn('w', 'h', 'i', 'l', 'e');
        when(mockReader.hasNext()).thenReturn(true, true, true, true, true, false);
        Lexer lexer = new Lexer(mockReader);
        assertEquals(lexer.readTokens().getName(), "while");
    }

    @Test
    public void hasMoreTokensEx() throws StreamException {
        IReader mockReader = mock(IReader.class);
        when(mockReader.read()).thenReturn('p');
        when(mockReader.hasNext()).thenThrow(new StreamException("Sm w wrong"));
        Lexer lexer = new Lexer(mockReader);
        assertFalse(lexer.hasMoreTokens());
    }


}