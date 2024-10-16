package kush;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student1 {
    int id;
    String name;
    int year;
    String mob;
    String email;

    public Student1(int id, String name, int year, String mob, String email) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.mob = mob;
        this.email = email;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + year + "," + mob + "," + email;
    }

    public static Student1 fromString(String line) {
        String[] parts = line.split(",");
        return new Student1(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
    }
}

public class Kp_file_operation {
    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student\n2. Display All Students\n3. Update Student\n4. Delete Student\n5. Search Student\n6. Exit");
            int choice = getInput(scanner);

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    searchStudent(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Year: ");
        int year = getInput(scanner);
        System.out.print("Enter Mobile Number: ");
        String mob = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        int id = getNextId();
        Student1 student = new Student1(id, name, year, mob, email);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(student.toString());
            writer.newLine();
            System.out.println("Student added successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void displayAllStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("ID | Name | Year | Mobile | Email");
            System.out.println("---------------------------------------");
            while ((line = reader.readLine()) != null) {
                Student1 student = Student1.fromString(line);
                System.out.println(student.id + " | " + student.name + " | " + student.year + " | " + student.mob + " | " + student.email);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter ID of the student to update: ");
        int idToUpdate = getInput(scanner);
        
        List<Student1> students = readStudentsFromFile();
        boolean found = false;

        for (Student1 student : students) {
            if (student.id == idToUpdate) {
                found = true;
                System.out.print("Enter new Name (current: " + student.name + "): ");
                student.name = scanner.nextLine();
                System.out.print("Enter new Year (current: " + student.year + "): ");
                student.year = getInput(scanner);
                System.out.print("Enter new Mobile Number (current: " + student.mob + "): ");
                student.mob = scanner.nextLine();
                System.out.print("Enter new Email (current: " + student.email + "): ");
                student.email = scanner.nextLine();
            }
        }

        if (found) {
            writeStudentsToFile(students);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student with ID " + idToUpdate + " not found.");
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter ID of the student to delete: ");
        int idToDelete = getInput(scanner);
        
        List<Student1> students = readStudentsFromFile();
        boolean found = false;

        for (Student1 student : students) {
            if (student.id == idToDelete) {
                students.remove(student);
                found = true;
                break;
            }
        }

        if (found) {
            writeStudentsToFile(students);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student with ID " + idToDelete + " not found.");
        }
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter ID of the student to search: ");
        int idToSearch = getInput(scanner);
        
        List<Student1> students = readStudentsFromFile();
        boolean found = false;

        for (Student1 student : students) {
            if (student.id == idToSearch) {
                System.out.println("Found Student: " + student.name + ", Year: " + student.year + ", Mobile: " + student.mob + ", Email: " + student.email);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + idToSearch + " not found.");
        }
    }

    private static List<Student1> readStudentsFromFile() {
        List<Student1> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(Student1.fromString(line));
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return students;
    }

    private static void writeStudentsToFile(List<Student1> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student1 student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static int getNextId() {
        List<Student1> students = readStudentsFromFile();
        return students.size() + 1; // Simple ID assignment
    }

    private static int getInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter an integer: ");
            }
        }
    }
}
