package verhuur;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.assertEquals;

public class HuurVoertuigTest {
    private List<HuurVoertuig> objects;

    @BeforeEach
    public void setUp() {
        HuurVoertuig[] seed = {new Fiets("Sparta", "Sign 2020", 8.76F, Fiets.FRAME_DAMES, 7),
                new Fiets("Batavus", "Winner N3", 6.55F, Fiets.FRAME_HEREN, 3),
                new Auto("Toyota", "Aygo", 31.45F, "37LHG3", 4, Auto.BRANDSTOF_BENZINE),
                new Auto("Ford", "Focus", 40.00F, "3LDZ21", 5, Auto.BRANDSTOF_BENZINE)};
        objects = new ArrayList<>(Arrays.asList(seed));
    }

    @Test
    @DisplayName("Should return merk")
    public void getMerk() {
        assertEquals("Sparta", objects.get(0).getMerk());

        assertEquals("Toyota", objects.get(2).getMerk());
    }

    @Test
    @DisplayName("Should return type")
    public void getType() {
        assertEquals("Winner N3", objects.get(1).getType());

        assertEquals("Focus", objects.get(3).getType());
    }

    @Test
    @DisplayName("Should return huurprijs")
    public void getHuurprijs() {
        assertEquals(8.76F, objects.get(0).getHuurprijs(), 0.1);

        assertEquals(31.45F, objects.get(2).getHuurprijs(), 0.1);
    }
}
