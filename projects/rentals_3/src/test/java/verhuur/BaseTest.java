package verhuur;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class BaseTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    public void tearDown() {
        System.setOut(standardOut);
    }

    /**
     * Return any captured stdout, e.g. from print statements
     *
     * @return The captured string
     */
    protected String getStdOut() {
        return outputStreamCaptor.toString().trim();
    }
}
