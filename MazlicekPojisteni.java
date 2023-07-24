
public class MazlicekPojisteni extends Pojisteni {

    // Konstruktor třídy Mazlíček
    public MazlicekPojisteni(double maxCastka, String poznamka) {
        super(maxCastka, poznamka);
    }

    // Metoda pro přepsání typu pojištění pro konkrétní instanci třídy
    @Override
    public String getTypPojisteni() {
        return "Pojištění domácího mazlíčka";
    }
}