package bzh.greta.bank.io;

import bzh.greta.bank.domain.MenuMode;

import java.util.Scanner;

public class MenuHandler {
    public static MenuMode execute() {
        displayMenu();
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        MenuMode[] values = MenuMode.values();
        return values[userChoice];
    }

    private static void displayMenu() {
        System.out.println("----------");
        System.out.println("0 : Consulter");
        System.out.println("1 : Retirer");
        System.out.println("2 : Déposer");
        System.out.println("----------");
    }
}
