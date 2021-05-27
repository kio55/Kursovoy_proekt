package it.sevenbits.formatter.Reader;

import it.sevenbits.formatter.Exceptions.StreamException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReadFileTest {

    @Test(expected = StreamException.class)
    public void CreateReaderEx() throws StreamException {
        ReadFile reader = new ReadFile("./");
    }

    @Test
    public void CreateReader() throws StreamException {
        ReadFile reader = new ReadFile("./src/test/resources/text.txt");
    }

    @Test
    public void read() throws StreamException {
        ReadFile reader = new ReadFile("./src/test/resources/text.txt");
        assertEquals(reader.read(), 'z');
    }

    @Test(expected = StreamException.class)
    public void readEx() throws StreamException {
        ReadFile reader = new ReadFile("./src/test/resources/text.txt");
        reader.close();
        reader.read();
    }


    @Test
    public void hasNext() throws StreamException {
        ReadFile reader = new ReadFile("./src/test/resources/text.txt");
        assertTrue(reader.hasNext());
    }

    @Test(expected = StreamException.class)
    public void hasNextEx() throws StreamException {
        ReadFile reader = new ReadFile("./src/test/resources/text.txt");
        reader.close();
        assertFalse(reader.hasNext());
    }

    @Test
    public void close() {
        try (ReadFile reader = new ReadFile("./src/test/resources/text.txt")) {

        } catch (StreamException e) {
            e.printStackTrace();
        }
    }
}