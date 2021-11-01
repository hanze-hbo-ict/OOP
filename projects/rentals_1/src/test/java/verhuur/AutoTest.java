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

public class AutoTest extends BaseTest {
    private List<Auto> objects;
    private String[][] strings;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();

        Auto[] seed = {new Auto("Toyota", "Aygo", 31.45F, "37LHG3", 4, Auto.BRANDSTOF_BENZINE),
                new Auto("Ford", "Focus", 40.00F, "3LDZ21", 5, Auto.BRANDSTOF_BENZINE),
                new Auto("Citroen", "C4 Cactus", 33.20F, "0PFD29", 5, Auto.BRANDSTOF_DIESEL)};
        objects = new ArrayList<>(Arrays.asList(seed));

        String[][] out = {{"Toyota Aygo", "Toyota Aygo 37LHG3, benzine, 4 personen"},
                {"Ford Focus", "Ford Focus 3LDZ21, benzine, 5 personen"},
                {"Citroen C4 Cactus", "Citroen C4 Cactus 0PFD29, diesel, 5 personen"}};
        strings = out;
    }

    @Override
    @AfterEach
    public void tearDown() {
        super.tearDown();
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
}
