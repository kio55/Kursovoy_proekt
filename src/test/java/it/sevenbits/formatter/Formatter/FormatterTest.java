package it.sevenbits.formatter.Formatter;

import it.sevenbits.formatter.Exceptions.StreamException;
import it.sevenbits.formatter.Lexer.LexerFactory;
import it.sevenbits.formatter.Reader.ReadFromString;
import it.sevenbits.formatter.Writer.WriterToString;
import org.junit.Test;

import static org.junit.Assert.*;

public class FormatterTest {
    LexerFactory lf = new LexerFactory();
    private final Formatter formatter = new Formatter(lf);
    private final ReadFromString firstReader = new ReadFromString("{{{{}}}}");
    private final WriterToString firstWriter = new WriterToString();
    private final ReadFromString secondReader = new ReadFromString("aaa { bbbb; ccc;}");
    private final WriterToString secondWriter = new WriterToString();
    private final ReadFromString thirdReader = new ReadFromString("aaa { bbbb; fff { trtryy; hhhh; } else { bsufg; } ccc;}");
    private final WriterToString thirdWriter = new WriterToString();
    private final ReadFromString fourthReader = new ReadFromString("public class HelloWorld { public static void main(String[] args) { System.out.println(\"Hello, World\");}}");
    private final WriterToString fourthWriter = new WriterToString();
    @Test
    public void firstExampleFormatter() throws StreamException {
        formatter.format(firstReader, firstWriter);
        assertEquals("{\n    {\n        {\n            {\n            }\n        }\n    }\n}",
                firstWriter.getResult());
    }

    @Test
    public void secondExampleFormatter() throws StreamException {
        formatter.format(secondReader, secondWriter);
        assertEquals("aaa {\n    bbbb;\n    ccc;\n}",
                secondWriter.getResult());
    }

    @Test
    public void thirdExampleFormatter() throws StreamException {
        formatter.format(thirdReader, thirdWriter);
        assertEquals("aaa {\n    bbbb;\n    fff {\n        trtryy;\n        hhhh;\n    }\n    else {\n        bsufg;\n    }\n    ccc;\n}",
                thirdWriter.getResult());
    }

    @Test
    public void fourthExampleFormatter() throws StreamException {
        formatter.format(fourthReader, fourthWriter);
        assertEquals("public class HelloWorld {\n" +
                        "    public static void main(String[] args) {\n" +
                        "        System.out.println(\"Hello, World\");\n" +
                        "    }\n" +
                        "}",
                fourthWriter.getResult());
    }
}