import java.util.ArrayList;
import java.util.List;

public class Pojisteny {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telefon;
    private ArrayList<Pojisteni> pojisteni;

    // Konstruktor pro vytvoření instance pojištěné osoby
    public Pojisteny(String jmeno, String prijmeni, int vek, String telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
        this.pojisteni = new ArrayList<>();
    }

    // Přidání pojištění ke klientskému účtu
    public void pridejPojisteni(Pojisteni pojisteni) {
        this.pojisteni.add(pojisteni);
    }

    // Převedení informací o pojištěné osobě a jejím pojištění na řetězec pro zobrazení
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jméno: ").append(jmeno).append(", Příjmení: ").append(prijmeni).append(", Věk: ").append(vek)
                .append(", Telefon: ").append(telefon).append(System.lineSeparator());
        sb.append("Pojištění:").append(System.lineSeparator());
        for (Pojisteni p : pojisteni) {
            sb.append(p).append(System.lineSeparator());
        }
        return sb.toString();
    }

    /**
     * Metoda pro získání seznamu pojištění, které jsou přiřazeny konkrétní osobě
     * @return - navrací seznam všech pojištění u pojištence
     */
    public ArrayList<Pojisteni> getSeznamPojisteni() {
        return pojisteni;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}