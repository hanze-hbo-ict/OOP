import java.util.ArrayList;

public class Verhuur {

    private ArrayList<HuurVoertuig> voertuigen = new ArrayList<>();

    /**
     * Voeg voertuig toe aan de administratie, met controle op al aanwezig zijn. Controle vindt
     * plaats met behulp van hashCode() en equals(). Een voertuig dat al aanwezig is, wordt niet
     * toegevoegd.
     *
     * @param nieuwVoertuig Toe te voegen huurvoertuig
     * @return true toegevoegd, false niet toegevoegd
     */
    public boolean voegHuurvoertuigToe(HuurVoertuig nieuwVoertuig) {
        // Controleren of voertuig al aanwezig is
        final int nieuwVoertuigHashCode = nieuwVoertuig.hashCode();
        for (HuurVoertuig voertuig : voertuigen) {
            if ((voertuig != nieuwVoertuig) && (voertuig.hashCode() == nieuwVoertuigHashCode)
                    && (voertuig.equals(nieuwVoertuig))) {
                return false; // voertuig al aanwezig
            }
        }
        // Voertuig nog niet aanwezig, daarom toevoegen
        voertuigen.add(nieuwVoertuig);
        return true;
    }

    /**
     * Geef aantal voertuigen terug
     *
     * @return aantal voertuigen
     */
    public int getAantalVoertuigen() {
        return voertuigen.size();
    }

    /**
     * Alle voertuigen printen op de console
     */
    public void printVoertuigen() {
        for (HuurVoertuig voertuig : voertuigen) {
            System.out.println(voertuig);
        }
    }

    /**
     * Geeft een lijst terug met alleen de auto's
     *
     * @return lijst Auto-objecten (uit de lijst huurvoertuigen in het veld voertuigen)
     */
    public ArrayList<Auto> getAutos() {
        return null; // opgave b
    }

    /**
     * Geeft een lijst terug met alleen de fietsen
     *
     * @return lijst Fiets-objecten (uit de lijst huurvoertuigen in het veld voertuigen)
     */
    public ArrayList<Fiets> getFietsen() {
        return null; // opgave b
    }

    public String meestVoorkomendeAutomerk() {
        return null; // opgave d
    }

}
