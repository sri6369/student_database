package college;

import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Details> studentList = new ArrayList<>();

    public static void main(String[] args) {
        inputStudents();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Display All Students");
            System.out.println("2. Display CSE Students");
            System.out.println("3. Transport Mode Count");
            System.out.println("4. Display Students by Gender");
            System.out.println("5. Sort by Name");
            System.out.println("6. Sort by Roll Number");
            System.out.println("7. Search by Name");
            System.out.println("8. Search by Roll Number");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> displayAll();
                case 2 -> displayCSE();
                case 3 -> displayTransportCount();
                case 4 -> displayByGender();
                case 5 -> sortByName();
                case 6 -> sortByRollNo();
                case 7 -> searchByName();
                case 8 -> searchByRollNo();
                case 9 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void inputStudents() {
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for student " + i + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Roll No: ");
            int rno = sc.nextInt();
            sc.nextLine();

            System.out.print("Department: ");
            String dept = sc.nextLine();

            System.out.print("Transport Mode: ");
            String transport = sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("Mobile Number: ");
            String mobile = sc.nextLine();

            System.out.print("Email ID: ");
            String email = sc.nextLine();

            studentList.add(new Details(name, rno, dept, transport, gender, mobile, email));
        }
    }

    private static void displayAll() {
        System.out.println("\nAll Students:\n");
        for (Details student : studentList) {
            System.out.println(student);
            System.out.println();
        }
    }

    private static void displayCSE() {
        System.out.println("\nCSE Students:\n");
        for (Details student : studentList) {
            if (student.getDept().equalsIgnoreCase("CSE")) {
                System.out.println(student.getName() + " - " + student.getRno());
            }
        }
    }

    private static void displayTransportCount() {
        System.out.println("\nTransport Mode Count:\n");
        HashMap<String, Integer> transportCount = new HashMap<>();
        for (Details student : studentList) {
            transportCount.put(student.getTransport(), transportCount.getOrDefault(student.getTransport(), 0) + 1);
        }
        for (String transport : transportCount.keySet()) {
            System.out.println(transport + " : " + transportCount.get(transport));
        }
    }

    private static void displayByGender() {
        System.out.println("\nStudents by Gender:\n");
        HashMap<String, List<String>> genderMap = new HashMap<>();

        for (Details student : studentList) {
            genderMap.putIfAbsent(student.getGender(), new ArrayList<>());
            genderMap.get(student.getGender()).add(student.getName());
        }

        for (String gender : genderMap.keySet()) {
            System.out.println(gender + ":");
            for (String name : genderMap.get(gender)) {
                System.out.println("  " + name);
            }
        }
    }

    private static void sortByName() {
        studentList.sort(Comparator.comparing(Details::getName));
        System.out.println("\nStudents Sorted by Name:\n");
        displayAll();
    }

    private static void sortByRollNo() {
        studentList.sort(Comparator.comparingInt(Details::getRno));
        System.out.println("\nStudents Sorted by Roll Number:\n");
        displayAll();
    }

    private static void searchByName() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Details student : studentList) {
            if (student.getName().toLowerCase().contains(name)) {
                System.out.println("\n" + student);
                found = true;
            }
        }
        if (!found) System.out.println("No student found with that name.");
    }

    private static void searchByRollNo() {
        System.out.print("Enter roll number to search: ");
        int rno = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (Details student : studentList) {
            if (student.getRno() == rno) {
                System.out.println("\n" + student);
                found = true;
            }
        }
        if (!found) System.out.println("No student found with that roll number.");
    }
}
