
public class AutoPojisteni extends Pojisteni {

    // Konstruktor třídy Auto pojištění
    public AutoPojisteni(double maxCastka, String poznamka) {
        super(maxCastka, poznamka);
    }

    // Metoda pro přepsání typu pojištění pro konkrétní instanci třídy
    @Override
    public String getTypPojisteni() {
        return "Pojištění auta";
    }
}