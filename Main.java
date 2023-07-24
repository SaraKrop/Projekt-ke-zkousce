import java.util.*;

public class Main {
    public static void main(String[] args) {
        Aplikace aplikace = new Aplikace();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            aplikace.zobrazMenu();

            int volba;
            // Ošetření nečíselného vstupu od uživatele
            try {
                volba = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Neplatná volba, zadejte platné číslo volby.");
                scanner.nextLine();
                continue;
            }


            switch (volba) {
                case 1:
                    // Přidání pojištěného
                    aplikace.pridatPojisteneho(scanner);
                    break;
                case 2:
                    // Zobrazení seznamu pojištěných
                    aplikace.zobrazSeznamPojisteny();
                    break;
                case 3:
                    // Vyhledání pojištěného
                    aplikace.vyhledejPojisteneho(scanner);
                    break;
                case 4:
                    // Úprava pojištěného
                    aplikace.upravPojisteneho(scanner);
                    break;
                case 5:
                    // Odstranění pojištěného
                    aplikace.odstranPojisteneho(scanner);
                    break;
                case 6:
                    // Odstranění pojištění pojištěného
                    aplikace.odstranPojisteniPojisteneho(scanner);
                    break;
                case 0:
                    // Konec programu
                    System.out.println("Děkujeme za využití naší aplikace.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Neplatná volba, zadejte platné číslo volby.");
            }
        }
    }
}