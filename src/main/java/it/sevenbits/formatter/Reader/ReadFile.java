package it.sevenbits.formatter.Reader;

import it.sevenbits.formatter.Exceptions.StreamException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * character-by-character reading from file
 */
public class ReadFile implements IReader, AutoCloseable {
    private final BufferedReader bufferedReader;

    /**
     * default constructor
     * @param path file path
     * @throws StreamException if file cant open
     */

    public ReadFile(final String path) throws StreamException {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            throw new StreamException("Cant open file");
        }
    }

    @Override
    public char read() throws StreamException {
        char res;
        try {
            res = (char) bufferedReader.read();
        } catch (IOException e) {
            throw new StreamException("Cant work with file :(");
        }
        return res;
    }

    @Override
    public boolean hasNext() throws StreamException {
        try {
            return bufferedReader.ready();
        } catch (IOException e) {
            throw new StreamException("Cant work with file :(");
        }
    }

    @Override
    public void close() throws StreamException {
        try {
            bufferedReader.close();
        } catch (Exception e) {
            throw new StreamException("Cant close file reader");
        }
    }
}
