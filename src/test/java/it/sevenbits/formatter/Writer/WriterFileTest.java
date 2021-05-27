package it.sevenbits.formatter.Writer;

import it.sevenbits.formatter.Exceptions.StreamException;
import it.sevenbits.formatter.Reader.ReadFile;
import org.junit.Test;

import static org.junit.Assert.*;

public class WriterFileTest {

    @Test
    public void write() throws StreamException {
        WriterFile writerFile = new WriterFile("./123.txt");
        ReadFile readFile = new ReadFile("./123.txt");
        writerFile.write('c');
        writerFile.close();
        assertEquals('c', readFile.read());
    }

    @Test(expected = StreamException.class)
    public void writeEx() throws StreamException {
        WriterFile writerFile = new WriterFile("./123.txt");
        writerFile.close();
        writerFile.write('c');
    }

    @Test(expected = StreamException.class)
    public void writerCreateEx() throws StreamException {
        WriterFile writerFile = new WriterFile("./");
    }

    @Test
    public void writerCreate() throws StreamException {
        WriterFile writerFile = new WriterFile("./123.txt");
        WriterFile writerFileSame = new WriterFile("./123.txt");
    }

    @Test
    public void close() {
        try (WriterFile writerFile = new WriterFile("./123.txt")) {
            writerFile.write('c');
        } catch (StreamException e) {
            e.printStackTrace();
        }
    }
}