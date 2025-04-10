import java.util.*;

public class Practicalno11 {

    // Student class to hold student details
    static class Student {
        String regNo;
        String name;
        int age;
        String branch;

        Student(String regNo, String name, int age, String branch) {
            this.regNo = regNo;
            this.name = name;
            this.age = age;
            this.branch = branch;
        }

        void display() {
            System.out.println("Reg No : " + regNo);
            System.out.println("Name   : " + name);
            System.out.println("Age    : " + age);
            System.out.println("Branch : " + branch);
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        while (true) {
            System.out.println("===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Reg No");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter Reg No (e.g., 2023bit034): ");
                String regNo = scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter Branch: ");
                String branch = scanner.nextLine();

                studentList.add(new Student(regNo, name, age, branch));
                System.out.println("Student added successfully\n");

            } else if (choice == 2) {
                System.out.println("\n--- All Students ---");
                for (Student s : studentList) {
                    s.display();
                }

            } else if (choice == 3) {
                System.out.print("Enter Reg No to search: ");
                String regNo = scanner.nextLine();
                boolean found = false;
                for (Student s : studentList) {
                    if (s.regNo.equalsIgnoreCase(regNo)) {
                        System.out.println("Student Found:");
                        s.display();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found\n");
                }

            } else if (choice == 4) {
                System.out.print("Enter Reg No to delete: ");
                String regNo = scanner.nextLine();
                boolean removed = studentList.removeIf(s -> s.regNo.equalsIgnoreCase(regNo));
                if (removed) {
                    System.out.println("Student deleted successfully\n");
                } else {
                    System.out.println("Student not found\n");
                }

            } else if (choice == 5) {
                System.out.println("Exiting... Thank you");
                break;
            } else {
                System.out.println("Invalid choice, try again\n");
            }
        }

        scanner.close();
    }
}


