import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberDisplayTest {
    @Test
    @DisplayName("Constructor should set value larger than limit to 0")
    public void testConstructorWithLargeValue() {
        NumberDisplay hour = new NumberDisplay(24, 100);

        assertEquals(0, hour.getValue());
    }

    @Test
    @DisplayName("Counstructor should set limit")
    public void testConstructorSetsLimit() {
        NumberDisplay hour = new NumberDisplay(24);

        assertEquals(hour.getLimit(), 24);
    }

    @Test
    @DisplayName("Constructor should set default value to 0")
    public void testConstructorSetsDefaultValue() {
        NumberDisplay hour = new NumberDisplay(24);

        assertEquals(0, hour.getValue());
    }

    @Test
    @DisplayName("Value should not be set when larger than limit")
    public void testSetLargeValue() {
        NumberDisplay hour = new NumberDisplay(24);

        hour.setValue(100);

        assertEquals(0, hour.getValue());
    }

    @Test
    @DisplayName("Value should not be set when smaller than limit")
    public void testSetSmallerValue() {
        NumberDisplay hour = new NumberDisplay(24);

        hour.setValue(-100);

        assertEquals(0, hour.getValue());
    }

    @Test
    @DisplayName("Value within the limit boundary should be set")
    public void testSetValue() {
        NumberDisplay hour = new NumberDisplay(24);

        hour.setValue(10);

        assertEquals(10, hour.getValue());
    }

    @Test
    @DisplayName("Should return the current value")
    public void testGetValue() {
        NumberDisplay hour = new NumberDisplay(24, 10);

        assertEquals(10, hour.getValue());
    }

    @Test
    @DisplayName("Should return the limit")
    public void testGetLimit() {
        NumberDisplay hour = new NumberDisplay(24, 10);

        assertEquals(24, hour.getLimit());
    }

    @Test
    @DisplayName("Increment within limit should return false")
    public void testIncrementWithinLimit() {
        NumberDisplay hour = new NumberDisplay(12);

        boolean result = hour.increment();

        assertFalse(result);
    }

    @Test
    @DisplayName("Increment should indicate a rollover with true")
    public void testIncrementShouldRollover() {
        boolean result;
        NumberDisplay other;

        other = new NumberDisplay(15, 14);
        result = other.increment();

        assertTrue(result);

        other = new NumberDisplay(15, 0);
        result = other.increment();

        assertFalse(result);
    }

    @Test
    @DisplayName("Should return value in a readable format")
    public void testToString() {
        NumberDisplay hour = new NumberDisplay(24, 5);

        assertEquals("05", hour.toString());
    }
}
