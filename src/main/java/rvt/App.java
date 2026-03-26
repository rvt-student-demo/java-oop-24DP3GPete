package rvt;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nIzvele: register | show | change | delete | exit");
            choice = sc.next().toLowerCase();

            switch (choice) {
                case "register" -> manager.register(sc);
                case "r" -> manager.register(sc);
                case "show" -> manager.showAll();
                case "s" -> manager.showAll();
                case "change" -> {
                    System.out.print("Ievadi personas kodu mainai: ");
                    manager.update(sc.next(), sc);
                }
                case "c" -> {
                    System.out.print("Ievadi personas kodu mainai: ");
                    manager.update(sc.next(), sc);
                }
                case "delete" -> {
                    System.out.print("Ievadi personas kodu dzesanai: ");
                    manager.remove(sc.next());
                }
                case "d" -> {
                    System.out.print("Ievadi personas kodu dzesanai: ");
                    manager.remove(sc.next());
                }
            }
        } while (!choice.equals("exit") && !choice.equals("e"));
    }
}