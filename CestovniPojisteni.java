
public class CestovniPojisteni extends Pojisteni {

    // Konstruktor třídy Cestovní pojištění
    public CestovniPojisteni(double maxCastka, String poznamka) {
        super(maxCastka, poznamka);
    }

    // Metoda pro přepsání typu pojištění pro konkrétní instanci třídy
    @Override
    public String getTypPojisteni() {
        return "Cestovní pojištění";
    }
}