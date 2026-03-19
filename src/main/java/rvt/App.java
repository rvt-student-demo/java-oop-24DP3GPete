package rvt;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Teacher ada = new Teacher("Ada Lovelace", "24 Maddox St. London W1S 2QN", 1200);
        // Teacher esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 00100 Helsinki", 5400);
        // System.out.println(ada);
        // System.out.println(esko);

        // Student ollie = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");

        // int i = 0;
        // while (i < 25) {
        //     ollie.study();
        //     i = i + 1;
        // }
        // System.out.println(ollie);


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