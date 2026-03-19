package rvt;

import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String FILE_NAME = "data/studenti.csv";

    public static void saveStudents(List<Student> students) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                pw.println(s.toCsvRow());
            }
        } catch (IOException e) {
            System.err.println("Kluda saglabajot failu: " + e.getMessage());
        }
    }

    public static List<Student> loadStudents() {
        List<Student> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] d = sc.nextLine().split(",");
                if (d.length == 5) {
                    list.add(new Student(d[0], d[1], d[2], d[3], d[4]));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fails netika atrasts.");
        }
        return list;
    }
}