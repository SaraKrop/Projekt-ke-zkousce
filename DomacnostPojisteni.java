
public class DomacnostPojisteni extends Pojisteni {

    // Konstruktor třídy Domácí pojištění
    public DomacnostPojisteni(double maxCastka, String poznamka) {
        super(maxCastka, poznamka);
    }

    // Metoda pro přepsání typu pojištění pro konkrétní instanci třídy
    @Override
    public String getTypPojisteni() {
        return "Pojištění domácnosti";
    }
}