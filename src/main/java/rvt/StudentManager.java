package rvt;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = FileHandler.loadStudents();
    }

    public void showAll() {
        if (students.isEmpty()) {
            System.out.println("\n[!] Sistema nav registretu studentu.");
            return;
        }

        // 1. Definējam tabulas rāmja līnijas un kolonnu platumus
        // + (17 svītras) + (17 svītras) + (27 svītras) + (17 svītras) + (22 svītras) +
        String horizontalLine = "+-----------------+-----------------+---------------------------+-----------------+----------------------+";
        // Definējam formātu: %-15s nozīmē tekstu, kas izlīdzināts pa kreisi 15 rakstzīmju platumā
        String rowFormat = "| %-15s | %-15s | %-25s | %-15s | %-20s |%n";

        // 2. Izvadam tabulas galvu (Header)
        System.out.println("\n" + horizontalLine);
        System.out.printf(rowFormat, "Vards", "Uzvards", "E-pasts", "Pers. kods", "Registrets");
        System.out.println(horizontalLine);

        // 3. Izvadam visus datusF
        for (Student s : students) {
            System.out.printf(rowFormat, 
                s.getVards(), 
                s.getUzvards(), 
                s.getEpasts(), 
                s.getPersKods(), 
                s.getRegLaiks());
        }

        // 4. Noslēdzošā līnija
        System.out.println(horizontalLine);
    }

    public void register(Scanner sc) {
        System.out.println("\n--- Jauna studenta registracija ---");
        System.out.print("Vards: "); String v = sc.next();
        System.out.print("Uzvards: "); String u = sc.next();
        System.out.print("E-pasts: "); String e = sc.next();
        System.out.print("Pers. kods (XXXXXX-XXXXX): "); String pk = sc.next();

        if (Validator.isValidName(v) && Validator.isValidName(u) && Validator.isValidEmail(e) && Validator.isValidPersKods(pk)) {
            String laiks = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            students.add(new Student(v, u, e, pk, laiks));
            FileHandler.saveStudents(students);
            System.out.println("[V] Students veiksmigi pievienots!");
        } else {
            System.out.println("[X] Kluda: Ievaditie dati neatbilst prasibam (RegEx parbaude neizdevas).");
        }
    }

    public void remove(String pk) {
        boolean removed = students.removeIf(s -> s.getPersKods().equals(pk));
        if (removed) {
            FileHandler.saveStudents(students);
            System.out.println("[V] Students ar personas kodu " + pk + " ir dzests.");
        } else {
            System.out.println("[X] Students ar sadu personas kodu netika atrasts.");
        }
    }
}