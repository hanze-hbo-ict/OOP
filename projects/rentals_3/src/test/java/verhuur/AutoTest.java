package verhuur;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AutoTest {
    private List<Auto> objects;
    private String[][] strings;

    @BeforeEach
    public void setUp() {
        Auto[] seed = {new Auto("Toyota", "Aygo", 31.45F, "37LHG3", 4, Auto.BRANDSTOF_BENZINE),
                new Auto("Ford", "Focus", 40.00F, "3LDZ21", 5, Auto.BRANDSTOF_BENZINE),
                new Auto("Citroen", "C4 Cactus", 33.20F, "0PFD29", 5, Auto.BRANDSTOF_DIESEL)};
        objects = new ArrayList<>(Arrays.asList(seed));

        String[][] out = {{"Toyota Aygo", "Toyota Aygo 37LHG3, benzine, 4 personen"},
                {"Ford Focus", "Ford Focus 3LDZ21, benzine, 5 personen"},
                {"Citroen C4 Cactus", "Citroen C4 Cactus 0PFD29, diesel, 5 personen"}};
        strings = out;
    }

    @Test
    @DisplayName("Should inherit from HuurVoertuig")
    public void testIsIsAHuurvoertuig() {
        Auto auto = new Auto("Toyota", "Aygo", 31.45F, "37LHG3", 4, Auto.BRANDSTOF_BENZINE);

        assertInstanceOf(HuurVoertuig.class, auto);
    }

    @Test
    @DisplayName("Should return beschrijving")
    public void testBeschrijving() {
        String expected;

        for (int i = 0; i < objects.size(); i++) {
            expected = strings[i][0];
            assertEquals(expected, objects.get(i).getBeschrijving());
        }
    }

    @Test
    @DisplayName("Should return a correct string representation")
    public void testToString() {
        String expected;

        for (int i = 0; i < objects.size(); i++) {
            expected = strings[i][1];
            assertEquals(expected, objects.get(i).toString());
        }
    }

    @Test
    @DisplayName("Should return kenteken")
    public void testGetKenteken() {
        assertEquals("37LHG3", objects.get(0).getKenteken());
    }

    @Test
    @DisplayName("Should return aantalInzittenden")
    public void testGetAantalInzittenden() {
        assertEquals(5, objects.get(1).getAantalInzittenden());
    }

    @Test
    @DisplayName("Should return brandstof")
    public void testGetBrandstof() {
        assertEquals(1, objects.get(0).getBrandstof());

        assertEquals(2, objects.get(2).getBrandstof());
    }

    @Test
    @DisplayName("Should test for equality")
    public void testEquals() {
        assertTrue(objects.get(0).equals(objects.get(0)));

        HuurVoertuig other =
                new Auto("Toyota", "Aygo", 31.45F, "37LHG3", 4, Auto.BRANDSTOF_BENZINE);

        assertTrue(objects.get(0).equals(other));

        assertFalse(objects.get(0).equals("Other"));

        other = new Fiets("Sparta", "Sign 2020", 8.76F, Fiets.FRAME_DAMES, 7);

        assertFalse(objects.get(0).equals(other));
    }
}
