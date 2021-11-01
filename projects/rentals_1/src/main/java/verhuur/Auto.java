public class Auto {

    private String merk;
    private String type;
    private float huurprijs;
    private String kenteken;
    private int aantalInzittenden;
    private int brandstof;

    public static final int BRANDSTOF_BENZINE = 1;
    public static final int BRANDSTOF_DIESEL = 2;
    public static final int BRANDSTOF_ELEKTRISCH = 3;

    public Auto(String merk, String type, float huurprijs, String kenteken, int aantalInzittenden,
            int brandstof) {
        this.merk = merk;
        this.type = type;
        this.huurprijs = huurprijs;
        this.kenteken = kenteken;
        this.aantalInzittenden = aantalInzittenden;
        this.brandstof = brandstof;
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

    public String getKenteken() {
        return kenteken;
    }

    public int getAantalInzittenden() {
        return aantalInzittenden;
    }

    public int getBrandstof() {
        return brandstof;
    }
}
