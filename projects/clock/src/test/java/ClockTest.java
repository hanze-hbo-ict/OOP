import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClockTest {
    @Test
    @DisplayName("Constructor should set value larger than limit to 0")
    public void testConstructorWithLargerValues() {
        Clock clock = new Clock(25, 60);

        assertEquals(0, clock.getMinute());
        assertEquals(0, clock.getHour());
    }

    @Test
    @DisplayName("Minute should not be set when larger than limit")
    public void testSetLargerMinute() {
        Clock clock = new Clock(10, 30);

        clock.setMinute(100);

        assertEquals(30, clock.getMinute());
    }

    @Test
    @DisplayName("Hour should not be set when larger than limit")
    public void testSetLargerHour() {
        Clock clock = new Clock(10, 30);

        clock.setHour(100);

        assertEquals(10, clock.getHour());
    }

    @Test
    @DisplayName("Minute should not be set when smaller than limit")
    public void testSetSmallerMinute() {
        Clock clock = new Clock(10, 30);

        clock.setMinute(-100);

        assertEquals(30, clock.getMinute());
    }

    @Test
    @DisplayName("Hour should not be set when smaller than limit")
    public void testSetSmallerHour() {
        Clock clock = new Clock(10, 30);

        clock.setHour(-100);

        assertEquals(10, clock.getHour());
    }

    @Test
    @DisplayName("Minute and hour should roll over after reaching their limits")
    public void testTickShouldRollover() {
        Clock clock = new Clock(23, 59);

        clock.tick();

        assertEquals(0, clock.getMinute());
        assertEquals(0, clock.getHour());
    }

    @Test
    @DisplayName("Should return time in a readable format")
    public void testToString() {
        Clock clock = new Clock(23, 5);

        assertEquals("23:05", clock.toString());
    }
}
