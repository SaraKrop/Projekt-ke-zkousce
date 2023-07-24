
public abstract class Pojisteni {
    protected double maxCastka;
    protected String poznamka;

    /**
     * Konstruktor třídy Pojištění
     * @param maxCastka - hodnota pojištění zadaná od uživatele
     * @param poznamka  - více infromací o pojištění
     */
    public Pojisteni(double maxCastka, String poznamka) {
        this.maxCastka = maxCastka;
        this.poznamka = poznamka;
    }

    public abstract String getTypPojisteni();

    // Metoda pro vypsání informací o pojištění
    @Override
    public String toString() {
        return "Typ: " + getTypPojisteni() + ", Maximální částka: " + maxCastka + ", Poznámka: " + poznamka;
    }
}