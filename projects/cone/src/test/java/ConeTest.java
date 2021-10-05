import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConeTest {

    @Test
    @DisplayName("Should get cone radius")
    public void testGetRadius() {
        Cone c = new Cone(5.0, 10.0);

        assertEquals(c.getRadius(), 5.0);
    }

    @Test
    @DisplayName("Constructor sets radius as absolute value")
    public void testNegativeRadiusConstructor() {
        Cone c = new Cone(-5.0, 10.0);

        assertEquals(c.getRadius(), 5.0);
    }

    @Test
    @DisplayName("Constructor sets height as absolute value")
    public void testNegativeHeigthConstructor() {
        Cone c = new Cone(5.0, -10.0);

        assertEquals(c.getHeight(), 10.0);
    }

    @Test
    @DisplayName("Should set cone radius")
    public void testSetRadius() {
        Cone c = new Cone(5.0, 10.0);
        c.setRadius(7.5);

        assertEquals(c.getRadius(), 7.5);
    }

    @Test
    @DisplayName("Negative radius should not get set")
    public void testNegativeSetRadius() {
        Cone c = new Cone(5.0, 10.0);
        c.setRadius(-5);

        assertEquals(c.getRadius(), 5.0);
    }

    @Test
    @DisplayName("Negative height should not get set")
    public void testNegativeSetHeight() {
        Cone c = new Cone(5.0, 10.0);
        c.setHeight(-10);

        assertEquals(c.getHeight(), 10.0);
    }

    @Test
    @DisplayName("Should get cone height")
    public void testGetHeight() {
        Cone c = new Cone(5.0, 10.0);

        assertEquals(c.getHeight(), 10.0);
    }

    @Test
    @DisplayName("Should set cone height")
    public void testSetHeight() {
        Cone c = new Cone(5.0, 10.0);
        c.setHeight(15.0);

        assertEquals(c.getHeight(), 15.0);
    }

    @Test
    @DisplayName("Should return cone volume")
    public void testVolume() {
        Cone c = new Cone(1.0, 1.0);

        c.setRadius(30);
        c.setHeight(15);

        assertEquals(c.volume(), 14137.16, 0.01);

        c.setRadius(15);
        c.setHeight(30);

        assertEquals(c.volume(), 7068.58, 0.01);
    }

    @Test
    @DisplayName("Should return cone area")
    public void testArea() {
        Cone c = new Cone(5.0, 10.0);

        c.setRadius(30);
        c.setHeight(15);

        assertEquals(c.area(), 5988.60, 0.01);

        c.setRadius(15);
        c.setHeight(30);

        assertEquals(c.area(), 2287.44, 0.01);
    }
}