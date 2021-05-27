package it.sevenbits.formatter;


import it.sevenbits.formatter.Exceptions.StreamException;
import it.sevenbits.formatter.Lexer.LexerFactory;
import it.sevenbits.formatter.Reader.ReadFile;
import it.sevenbits.formatter.Writer.WriterFile;
import it.sevenbits.formatter.sm.FormatterSM.FormatterSM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class
 */
public final class Main {
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    /**
     * Demonstrates how the program works
     *
     * @param args arguments from console
     */
    public static void main(final String[] args) {
        LexerFactory lexerFactory = new LexerFactory();
        FormatterSM formatter = new FormatterSM(lexerFactory);
        try (WriterFile writer = new WriterFile(args[1]); ReadFile read = new ReadFile(args[0]);) {
            try {
                formatter.format(read, writer);
            } catch (StreamException se) {
                LOGGER.error(se.getMessage());
            }
        } catch (StreamException e) {
            LOGGER.error("Error");
        }
    }
    private Main() {
    }
}
