/**
 * Represents a clock.
 */
public class Clock {

    private int hour;
    private int minute;

    /**
     * Construct a Clock object with default values.
     */
    public Clock() {
        this.hour = 0;
        this.minute = 0;
    }

    /**
     * Construct a Clock object with given values.
     *
     * @param hour   The current hour
     * @param minute The current minute
     */
    public Clock(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Returns the hour.
     *
     * @return The current hour
     */
    public int getHour() {
        return this.hour;
    }

    /**
     * Returns the minute.
     *
     * @return The current minute
     */
    public int getMinute() {
        return this.minute;
    }

    /**
     * Sets the hour.
     *
     * @param hour The new hour
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * Sets the minute.
     *
     * @param minute The new minute
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * Prints the time in a simple format.
     *
     * @param c The Clock object
     */
    public static void printTime(Clock c) {
        System.out.print(c.hour);
        System.out.print(":");
        System.out.println(c.minute);
    }

    /**
     * Returns a String representation of the time.
     */
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }

    /**
     * Tests whether two times are equivalent.
     *
     * @param that The other Clock object
     * @return     True if equal else false
     */
    public boolean equals(Clock that) {
        return this.hour == that.hour && this.minute == that.minute;
    }

    /**
     * Adds 1 minute to the clock
     */
    public void tick() {
        minute += 1;

        if (minute >= 60) {
            minute -= 60;
            hour += 1;
        }

        if (hour >= 24) {
            hour -= 24;
        }
    }
}