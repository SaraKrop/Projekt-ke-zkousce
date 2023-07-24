import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Aplikace {
    private List<Pojisteny> seznamPojisteny = new ArrayList<>();

    // Metoda pro vypsání menu
    public void zobrazMenu() {
        System.out.println("----------------------");
        System.out.println("1 - Přidat pojištěného");
        System.out.println("2 - Zobrazit seznam pojištěných");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Upravit pojištěného");
        System.out.println("5 - Odstranit pojištěného");
        System.out.println("6 - Odstranit pojištění pojištěného");
        System.out.println("0 - Konec");
        System.out.println("----------------------");
    }

    /**
     * Metoda pro kontrolu vstupu od uživatele u částky pojištění;
     *
     * @param scanner - vstup od uživatele;
     * @param message - "Zadej částku" - text definován u pojištění;
     * @return - navrací částku pokud splňuje podmínky
     */
    private double overVstup(Scanner scanner, String message) {
        double value;
        while (true) {
            System.out.println(message);
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value <= 0) {
                    System.out.println("Neplatná hodnota. Zadejte platnou hodnotu větší než 0.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Neplatná hodnota. Zadejte platnou hodnotu vašeho pojištění (v Kč, bez mezer).");
            }
        }
        return value;
    }

    /**
     * Metoda pro přidání pojištěnce
     *
     * @param scanner - vstupy od uživatele pro jméno, příjmení, věk a telefonní číslo
     */
    public void pridatPojisteneho(Scanner scanner) {
        System.out.println("Zadej jméno: ");
        String jmeno = scanner.nextLine();

        System.out.println("Zadej příjmení: ");
        String prijmeni = scanner.nextLine();

        int vek;
        while (true) {
            System.out.println("Zadej věk: ");
            try {
                vek = Integer.parseInt(scanner.nextLine());
                if (vek <= 0) {
                    System.out.println("Neplatný věk. Zadejte platný věk.");
                    continue;
                }
                if (vek < 18) {
                    System.out.println("Omlouváme se, naše firma pojišťuje pouze dospělé osoby.");
                    return;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Neplatný věk. Zadejte platný věk.");
            }
        }

        String telefon;
        while (true) {
            System.out.println("Zadej telefonní číslo ve formátu +420_________ (9 číslic): ");
            telefon = scanner.nextLine();
            if (telefon.matches("\\d{9}")) {
                break;
            }
            System.out.println("Neplatné telefonní číslo. Zadejte přesně 9 číslic.");
        }

        Pojisteny pojisteny = new Pojisteny(jmeno, prijmeni, vek, telefon);

        // Metoda pro přidání pojištění k pojištěncům
        boolean pridatDalsiPojisteni = true;
        while (pridatDalsiPojisteni) {
            System.out.println("Vyber druh pojištění (1 - Cestovní pojištění, 2 - Pojištění domácnosti, 3 - Pojištění auta, 4 - Pojištění domácího mazlíčka, 5 - Nechci přidat žádné pojištění):");

            // Ověření vstupu od uživatele pro volbu pojištění
            int volbaPojisteni;
            while (true) {
                try {
                    volbaPojisteni = Integer.parseInt(scanner.nextLine());
                    if (volbaPojisteni < 1 || volbaPojisteni > 5) {
                        System.out.println("Neplatná volba, vyberte prosím jednu z možností.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Neplatná volba, zadejte číslo volby.");
                }
            }
            if (volbaPojisteni == 5) {
                pridatDalsiPojisteni = false;
                continue;
            }

            // Zpracování jednotlivých druhů pojištění podle výběru uživatele
            switch (volbaPojisteni) {
                case 1:
                    double castkaCestovni = overVstup(scanner, "Zadej částku cestovního pojištění v Kč:");

                    System.out.println("Zadej cíl cesty a délku pobytu (počet dnů):");
                    String poznamkaCestovni = scanner.nextLine();

                    CestovniPojisteni cestovniPojisteni = new CestovniPojisteni(castkaCestovni, poznamkaCestovni);
                    pojisteny.pridejPojisteni(cestovniPojisteni);
                    break;
                case 2:
                    double castkaDomacnost = overVstup(scanner, "Zadej částku pojištění domácnosti v Kč:");

                    System.out.println("Zadej adresu domácnosti (ve formátu: ulice a č.p., město):");
                    String poznamkaDomacnost = scanner.nextLine();

                    DomacnostPojisteni domacnostPojisteni = new DomacnostPojisteni(castkaDomacnost, poznamkaDomacnost);
                    pojisteny.pridejPojisteni(domacnostPojisteni);
                    break;
                case 3:
                    double castkaAuto = overVstup(scanner, "Zadej částku pojištění automobilu v Kč:");

                    System.out.println("Zadej SPZ vozu:");
                    String poznamkaAuto = scanner.nextLine();

                    AutoPojisteni autoPojisteni = new AutoPojisteni(castkaAuto, poznamkaAuto);
                    pojisteny.pridejPojisteni(autoPojisteni);
                    break;
                case 4:
                    double castkaMazlicek = overVstup(scanner, "Zadej částku pojištění mazlíčka v Kč:");

                    System.out.println("Zadej jméno a druh zvířete:");
                    String poznamkaMazlicek = scanner.nextLine();

                    MazlicekPojisteni mazlicekPojisteni = new MazlicekPojisteni(castkaMazlicek, poznamkaMazlicek);
                    pojisteny.pridejPojisteni(mazlicekPojisteni);
                    break;
                default:
                    System.out.println("Neplatná volba, zadejte platné číslo volby.");
            }
            System.out.println("Přejete si k pojištěnému přidat nějaké další pojištění? (ano/ne)");
            String volbaDalsihoPojisteni = scanner.nextLine();
            pridatDalsiPojisteni = volbaDalsihoPojisteni.equalsIgnoreCase("ano");
        }

        pridejPojisteneho(pojisteny);
    }

    // Metoda pro vypsání všech pojištěných
    public void zobrazSeznamPojisteny() {
        for (Pojisteny pojisteny : seznamPojisteny) {
            System.out.println(pojisteny);
        }
    }

    /**
     * Metoda pro vyhledání určitého pojištěného na základě jména a příjmení
     *
     * @param scanner - vstup od uživatele pro jméno a příjmení
     */
    public void vyhledejPojisteneho(Scanner scanner) {
        System.out.println("Zadej jméno: ");
        String jmeno = scanner.nextLine();

        System.out.println("Zadej příjmení: ");
        String prijmeni = scanner.nextLine();

        Pojisteny nalezenyPojisteny = najdiPojisteneho(jmeno, prijmeni);
        if (nalezenyPojisteny != null) {
            System.out.println("Nalezený pojištěný: " + nalezenyPojisteny);
        } else {
            System.out.println("Pojištěný nebyl nalezen.");
        }
    }

    /**
     * Metoda pro úpravu osobních informací pojištěného
     *
     * @param scanner - vstup od uživatele pro jméno a příjmení
     */
    public void upravPojisteneho(Scanner scanner) {
        System.out.println("Zadej jméno: ");
        String jmeno = scanner.nextLine();

        System.out.println("Zadej příjmení: ");
        String prijmeni = scanner.nextLine();

        Pojisteny pojisteny = najdiPojisteneho(jmeno, prijmeni);
        if (pojisteny != null) {
            System.out.println("Aktuální údaje pojištěného:");
            System.out.println(pojisteny);
            System.out.println("Zadej nové jméno: ");
            String noveJmeno = scanner.nextLine();

            System.out.println("Zadej nové příjmení: ");
            String novePrijmeni = scanner.nextLine();

            System.out.println("Zadej nový věk: ");
            int novyVek = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Zadej nové telefonní číslo: ");
            String noveTelefon = scanner.nextLine();

            pojisteny.setJmeno(noveJmeno);
            pojisteny.setPrijmeni(novePrijmeni);
            pojisteny.setVek(novyVek);
            pojisteny.setTelefon(noveTelefon);

            System.out.println("Pojištěný byl úspěšně upraven.");
        } else {
            System.out.println("Pojištěný nebyl nalezen.");
        }
    }

    /**
     * Metoda pro odstranění pojištěného
     *
     * @param scanner - vstup od uživatele (jméno a příjmení)
     */
    public void odstranPojisteneho(Scanner scanner) {
        System.out.println("Zadej jméno: ");
        String jmeno = scanner.nextLine();

        System.out.println("Zadej příjmení: ");
        String prijmeni = scanner.nextLine();

        boolean removed = seznamPojisteny.removeIf(p -> p.getJmeno().equals(jmeno) && p.getPrijmeni().equals(prijmeni));
        if (removed) {
            System.out.println("Pojištěný byl úspěšně odstraněn.");
        } else {
            System.out.println("Pojištěný nebyl nalezen.");
        }
    }

    /**
     * Metoda pro odstranění jednotlivých pojištění pojištěného
     *
     * @param scanner - vstup od uživatele (jméno, příjmení a výběr pojištění k odstranění)
     */
    public void odstranPojisteniPojisteneho(Scanner scanner) {
        System.out.println("Zadej jméno pojištěného: ");
        String jmeno = scanner.nextLine();

        System.out.println("Zadej příjmení pojištěného: ");
        String prijmeni = scanner.nextLine();

        Pojisteny pojisteny = najdiPojisteneho(jmeno, prijmeni);
        if (pojisteny != null) {
            System.out.println(pojisteny);
            System.out.println("Zadej číslo pojištění, které chceš odstranit:");
            int cisloPojisteni = scanner.nextInt();
            scanner.nextLine();

            List<Pojisteni> pojisteni = pojisteny.getSeznamPojisteni();
            if (cisloPojisteni >= 1 && cisloPojisteni <= pojisteni.size()) {
                pojisteni.remove(cisloPojisteni - 1);
                System.out.println("Pojištění bylo úspěšně odstraněno.");
            } else {
                System.out.println("Neplatné číslo pojištění.");
            }
        } else {
            System.out.println("Pojištěný nebyl nalezen.");
        }
    }

    /**
     * Metoda pro vyhledání pojištěného pro další práci s ním (odstranění a úpravu)
     *
     * @param jmeno    pojištěného
     * @param prijmeni pojištěného
     * @return pojištěného, pokud takový v seznamu je
     */
    private Pojisteny najdiPojisteneho(String jmeno, String prijmeni) {
        for (Pojisteny pojisteny : seznamPojisteny) {
            if (pojisteny.getJmeno().equals(jmeno) && pojisteny.getPrijmeni().equals(prijmeni)) {
                return pojisteny;
            }
        }
        return null;
    }

    /**
     * Metoda pro přidání pojištěného do seznamu
     * @param pojisteny - pojištěná osoba uvedena pod jménem, příjmením, věkem a tel.číslem
     */
    public void pridejPojisteneho(Pojisteny pojisteny) {
        seznamPojisteny.add(pojisteny);
    }
}
