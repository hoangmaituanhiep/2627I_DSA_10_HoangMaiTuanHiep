package week4;

import java.io.*;
import java.util.*;

public class b2 {

    static class Student {
        int id;
        String name;
        double gpa;

        Student(int id, String name, double gpa) {
            this.id = id;
            this.name = name;
            this.gpa = gpa;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double gpa = sc.nextDouble();
            students.add(new Student(id, name, gpa));
        }
        students.sort((a, b) -> {
            if (Double.compare(b.gpa, a.gpa) != 0) {
                return Double.compare(b.gpa, a.gpa); // Descending GPA
            }
            int nameCompare = a.name.compareToIgnoreCase(b.name);
            if (nameCompare != 0) {
                return nameCompare; // Ascending Name
            }
            return Integer.compare(a.id, b.id); // Ascending ID
        });

        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}