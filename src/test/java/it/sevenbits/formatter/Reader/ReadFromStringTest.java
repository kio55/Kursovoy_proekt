package it.sevenbits.formatter.Reader;

import it.sevenbits.formatter.Exceptions.StreamException;
import org.junit.Test;

import java.io.Reader;

import static org.junit.Assert.*;

public class ReadFromStringTest {

    @Test(expected = StreamException.class)
    public void readEmpty() throws StreamException {
        IReader reader = new ReadFromString("");
        reader.read();
    }
}