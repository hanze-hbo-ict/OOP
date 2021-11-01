package verhuur;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class FietsTest extends BaseTest {
    private List<Fiets> objects;
    private String[][] strings;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();

        Fiets[] seed = {new Fiets("Sparta", "Sign 2020", 8.76F, Fiets.FRAME_DAMES, 7),
                new Fiets("Batavus", "Winner N3", 6.55F, Fiets.FRAME_HEREN, 3),
                new Fiets("Gazelle", "Van Stael 2020", 9.00F, Fiets.FRAME_HEREN, 7)};
        objects = new ArrayList<>(Arrays.asList(seed));

        String[][] out = {{"Sparta Sign 2020", "Sparta Sign 2020, damesfiets, 7 versnellingen"},
                {"Batavus Winner N3", "Batavus Winner N3, herenfiets, 3 versnellingen"},
                {"Gazelle Van Stael 2020", "Gazelle Van Stael 2020, herenfiets, 7 versnellingen"}};
        strings = out;
    }

    @Override
    @AfterEach
    public void tearDown() {
        super.tearDown();
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
    @DisplayName("Should print correct info")
    public void testPrintInfo() {
        String expected;
        String actual;

        for (int i = 0; i < objects.size(); i++) {
            expected = strings[i][1];
            objects.get(i).printInfo();
            actual = getStdOut().split("\n")[i];

            assertEquals(expected, actual);
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
}
