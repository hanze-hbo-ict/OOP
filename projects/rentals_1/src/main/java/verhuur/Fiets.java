public class Fiets {

    private String merk;
    private String type;
    private float huurprijs;
    private int frame;
    private int aantalVersnellingen;

    public static final int FRAME_DAMES = 1;
    public static final int FRAME_HEREN = 2;

    public Fiets(String merk, String type, float huurprijs, int frame, int aantalVersnellingen) {
        this.merk = merk;
        this.type = type;
        this.huurprijs = huurprijs;
        this.frame = frame;
        this.aantalVersnellingen = aantalVersnellingen;
    }

    public String getMerk() {
        return merk;
    }

    public String getType() {
        return type;
    }

    public float getHuurprijs() {
        return huurprijs;
    }

    public int getFrame() {
        return frame;
    }

    public int getAantalVersnellingen() {
        return aantalVersnellingen;
    }
}
