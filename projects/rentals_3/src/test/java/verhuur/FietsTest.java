package verhuur;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class FietsTest {
    private List<Fiets> objects;
    private String[][] strings;

    @BeforeEach
    public void setUp() {
        Fiets[] seed = {new Fiets("Sparta", "Sign 2020", 8.76F, Fiets.FRAME_DAMES, 7),
                new Fiets("Batavus", "Winner N3", 6.55F, Fiets.FRAME_HEREN, 3),
                new Fiets("Gazelle", "Van Stael 2020", 9.00F, Fiets.FRAME_HEREN, 7)};
        objects = new ArrayList<>(Arrays.asList(seed));

        String[][] out = {{"Sparta Sign 2020", "Sparta Sign 2020, damesfiets, 7 versnellingen"},
                {"Batavus Winner N3", "Batavus Winner N3, herenfiets, 3 versnellingen"},
                {"Gazelle Van Stael 2020", "Gazelle Van Stael 2020, herenfiets, 7 versnellingen"}};
        strings = out;
    }

    @Test
    @DisplayName("Should inherit from HuurVoertuig")
    public void testIsAHuurVoertuig() {
        Fiets fiets = new Fiets("Sparta", "Sign 2020", 8.76F, Fiets.FRAME_DAMES, 7);

        assertInstanceOf(HuurVoertuig.class, fiets);
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
    @DisplayName("Should return frame")
    public void getFrame() {
        assertEquals(1, objects.get(0).getFrame());

        assertEquals(2, objects.get(1).getFrame());
    }

    @Test
    @DisplayName("Should return versnellingen")
    public void getAantalVersnellingen() {
        assertEquals(3, objects.get(1).getAantalVersnellingen());

        assertEquals(7, objects.get(2).getAantalVersnellingen());
    }

    @Test
    @DisplayName("Should test for equality")
    public void testEquals() {
        assertTrue(objects.get(0).equals(objects.get(0)));

        HuurVoertuig other = new Fiets("Sparta", "Sign 2020", 8.76F, Fiets.FRAME_DAMES, 7);

        assertTrue(objects.get(0).equals(other));

        assertFalse(objects.get(0).equals("Other"));

        other = new Auto("Toyota", "Aygo", 31.45F, "37LHG3", 4, Auto.BRANDSTOF_BENZINE);

        assertFalse(objects.get(0).equals(other));
    }
}
