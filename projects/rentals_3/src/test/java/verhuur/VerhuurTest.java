package verhuur;

import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class VerhuurTest extends BaseTest {
    private List<HuurVoertuig> objects;
    private Verhuur obj;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();

        HuurVoertuig[] seed = {new Fiets("Sparta", "Sign 2020", 8.76F, Fiets.FRAME_DAMES, 7),
                new Fiets("Batavus", "Winner N3", 6.55F, Fiets.FRAME_HEREN, 3),
                new Auto("Toyota", "Aygo", 31.45F, "37LHG3", 4, Auto.BRANDSTOF_BENZINE),
                new Auto("Ford", "Focus", 40.00F, "3LDZ21", 5, Auto.BRANDSTOF_BENZINE),
                new Fiets("Batavus", "Winner N3", 6.55F, Fiets.FRAME_DAMES, 3),
                new Auto("Toyota", "Yaris", 39.00F, "11AA12", 5, Auto.BRANDSTOF_BENZINE)};
        objects = new ArrayList<>(Arrays.asList(seed));

        obj = new Verhuur();
    }

    @Override
    @AfterEach
    public void tearDown() {
        super.tearDown();
    }

    @Test
    @DisplayName("Should add only unique")
    public void testVoegHuurvoertuigToe() {
        HuurVoertuig ob1 = new Fiets("Sparta", "Sign 2020", 8.76F, Fiets.FRAME_DAMES, 7);
        HuurVoertuig ob2 = new Fiets("Sparta", "Sign 2020", 8.76F, Fiets.FRAME_DAMES, 7);

        assertTrue(obj.voegHuurvoertuigToe(ob1));
        assertFalse(obj.voegHuurvoertuigToe(ob2));
    }

    @Test
    @DisplayName("Should return number of objects")
    public void testGetAantalVoertuigen() {
        for (HuurVoertuig entry : objects) {
            obj.voegHuurvoertuigToe(entry);
        }

        assertEquals(objects.size(), obj.getAantalVoertuigen());
    }

    @Test
    @DisplayName("Should print objects string representation")
    public void testPrintVoertuigen() {
        obj.voegHuurvoertuigToe(objects.get(0));
        obj.voegHuurvoertuigToe(objects.get(1));

        obj.printVoertuigen();

        String expected =
                "Sparta Sign 2020, damesfiets, 7 versnellingen\nBatavus Winner N3, herenfiets, 3 versnellingen";

        assertEquals(expected, getStdOut());
    }

    @Test
    @DisplayName("Should return Auto instances")
    public void testGetAutos() {
        obj.voegHuurvoertuigToe(objects.get(0));
        obj.voegHuurvoertuigToe(objects.get(2));

        List<Auto> actual = obj.getAutos();

        assertEquals(1, actual.size());
        assertEquals(objects.get(2), actual.get(0));
    }

    @Test
    @DisplayName("Should return Fiets instances")
    public void testGetFietsen() {
        obj.voegHuurvoertuigToe(objects.get(0));
        obj.voegHuurvoertuigToe(objects.get(2));

        List<Fiets> actual = obj.getFietsen();

        assertEquals(1, actual.size());
        assertEquals(objects.get(0), actual.get(0));
    }

    @Test
    @DisplayName("Should return most popular Auto merk")
    public void testMeestVoorkomendeAutomerk() {
        for (HuurVoertuig entry : objects) {
            obj.voegHuurvoertuigToe(entry);
        }

        assertEquals("Toyota", obj.meestVoorkomendeAutomerk());
    }

    @Test
    @DisplayName("Test custom hashCode")
    public void testHashCode() {
        if (obj.hashCode() != 1) {
            HashSet<HuurVoertuig> hset = new HashSet<>();

            for (int t = 0; t < 20000000; t++) {
                hset.add(new Auto("Test", "Test", 30F, "test", (t / 100) % 3 + 2, t % 3 + 1));
                hset.add(new Fiets("Test", "Test", 10F, t % 2 + 1, (t / 100) % 7));
            }

            assertEquals(23, hset.size());
        }
    }
}
