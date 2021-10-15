import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.ArrayList;

public class WarTest {
    @Test
    public void testEmpty() {
        ArrayList<Integer> deck = new ArrayList<Integer>();
        assertEquals(0, War.findWinner(deck));
    }

    @Test
    public void testOne() {
        ArrayList<Integer> deck = new ArrayList<>(Arrays.asList(2));
        assertEquals(1, War.findWinner(deck));
    }

    @Test
    public void testTwoA() {
        ArrayList<Integer> deck = new ArrayList<>(Arrays.asList(3, 2));
        assertEquals(1, War.findWinner(deck));
    }

    @Test
    public void testTwoB() {
        ArrayList<Integer> deck = new ArrayList<>(Arrays.asList(2, 3));
        assertEquals(-1, War.findWinner(deck));
    }
}
