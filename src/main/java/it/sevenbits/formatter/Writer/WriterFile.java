package it.sevenbits.formatter.Writer;

import it.sevenbits.formatter.Exceptions.StreamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * Class for character-by-character writing
 */
public class WriterFile implements IWriter, AutoCloseable {
    private static final Logger LOGGER = LoggerFactory.getLogger(WriterFile.class);
    private final Writer fileWriter;

    /**
     * Default constructor
     * @param path file path
     * @throws StreamException if cant work with file
     */
    public WriterFile(final String path) throws StreamException {
        File file = new File(path);
        try {
            if (!file.createNewFile()) {
                LOGGER.warn("Cant create file it already exist");
            }
            this.fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new StreamException("Cant work with file");
        }
    }

    @Override
    public void write(final char character) throws StreamException {
        try {
            fileWriter.write(character);
        } catch (IOException e) {
            throw new StreamException("Cant write to file");
        }

    }

    @Override
    public void close() throws StreamException {
        try {
            fileWriter.close();
        } catch (Exception e) {
            throw new StreamException("Cant close writer");
        }
    }
}
