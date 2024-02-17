// StudentManagement.java
// Importing Scanner class for user input
import java.util.Scanner;

// StudentManagement class for managing student records
public class StudentManagement {
    // Constant for maximum number of students
    private static final int MAX_STUDENTS = 100;

    // Array to store Student objects
    private Student[] studentArray = new Student[MAX_STUDENTS];

    // Variable to keep track of the number of students in the array
    private int count = 0;

    // Method to run the main menu of the program
    public void run() {
        // Creating Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Variable to store user choice
        int choice;

        // Menu loop
        do {
            // Displaying menu options
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Position");
            System.out.println("6. Update Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");

            // Prompting user for choice
            System.out.print("Enter your choice: ");
            // Reading user input
            choice = scanner.nextInt();

            // Switch statement to perform actions based on user choice
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchByPRN();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    searchByPosition();
                    break;
                case 6:
                    updateStudent();
                    break;
                case 7:
                    deleteStudent();
                    break;
                case 8:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 8);

        // Closing the Scanner object
        scanner.close();
    }

    // Method to add a new student to the array
    private void addStudent() {
        // Creating Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Prompting user for PRN
        System.out.print("Enter PRN: ");
        // Reading PRN from user input
        int prn = scanner.nextInt();
        // Consuming the newline character
        scanner.nextLine();
        // Prompting user for Name
        System.out.print("Enter Name: ");
        // Reading Name from user input
        String name = scanner.nextLine();
        // Prompting user for Date of Birth
        System.out.print("Enter Date of Birth: ");
        // Reading Date of Birth from user input
        String dob = scanner.nextLine();
        // Prompting user for Marks
        System.out.print("Enter Marks: ");
        // Reading Marks from user input
        int marks = scanner.nextInt();

        // Creating a new Student object with the provided information
        Student student = new Student(prn, name, dob, marks);
        // Adding the new student to the array
        studentArray[count++] = student;

        // Displaying success message
        System.out.println("Student added successfully!\n");
    }

    // Method to display all students in the array
    private void displayStudents() {
        // Checking if there are no students in the array
        if (count == 0) {
            // Displaying a message if there are no students
            System.out.println("No students to display.\n");
        } else {
            // Displaying the list of students
            System.out.println("List of Students:");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + studentArray[i]);
            }
            System.out.println();
        }
    }

    // Method to search for a student by PRN
    private void searchByPRN() {
        // Creating Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Prompting user for PRN to search
        System.out.print("Enter PRN to search: ");
        // Reading PRN from user input
        int searchPRN = scanner.nextInt();

        // Iterating through the array to find the student with the specified PRN
        for (int i = 0; i < count; i++) {
            // Checking if the PRN matches
            if (studentArray[i].getPrn() == searchPRN) {
                // Displaying information about the found student
                System.out.println("Student found:\n" + studentArray[i] + "\n");
                // Exiting the method
                return;
            }
        }

        // Displaying a message if no student with the specified PRN is found
        System.out.println("Student with PRN " + searchPRN + " not found.\n");
    }

    // Method to search for a student by position in the array
    private void searchByPosition() {
        // Creating Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Prompting user for position to search
        System.out.print("Enter position to search: ");
        // Reading position from user input
        int position = scanner.nextInt();

        // Checking if the specified position is valid
        if (position >= 1 && position <= count) {
            // Displaying information about the student at the specified position
            System.out.println("Student at position " + position + ":\n" + studentArray[position - 1] + "\n");
        } else {
            // Displaying an error message for an invalid position
            System.out.println("Invalid position. Please enter a valid position.\n");
        }
    }

    // Method to search for a student by Name
    private void searchByName() {
        // Creating Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Prompting user for Name to search
        System.out.print("Enter Name to search: ");
        // Reading Name from user input
        String searchName = scanner.nextLine();

        // Iterating through the array to find the student with the specified Name
        for (int i = 0; i < count; i++) {
            // Checking if the Name matches (case-insensitive comparison)
            if (studentArray[i].getName().equalsIgnoreCase(searchName)) {
                // Displaying information about the found student
                System.out.println("Student found:\n" + studentArray[i] + "\n");
                // Exiting the method
                return;
            }
        }

        // Displaying a message if no student with the specified Name is found
        System.out.println("Student with Name " + searchName + " not found.\n");
    }

    // Method to update the Marks of a student by PRN
    private void updateStudent() {
        // Creating Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Prompting user for PRN to update
        System.out.print("Enter PRN to update: ");
        // Reading PRN from user input
        int updatePRN = scanner.nextInt();

        // Iterating through the array to find the student with the specified PRN
        for (int i = 0; i < count; i++) {
            // Checking if the PRN matches
            if (studentArray[i].getPrn() == updatePRN) {
                // Prompting user for new Marks
                System.out.print("Enter new Marks: ");
                // Reading new Marks from user input
                int newMarks = scanner.nextInt();
                // Updating the Marks of the found student
                studentArray[i].setMarks(newMarks);
                // Displaying success message
                System.out.println("Student updated successfully!\n");
                // Exiting the method
                return;
            }
        }

        // Displaying a message if no student with the specified PRN is found
        System.out.println("Student with PRN " + updatePRN + " not found.\n");
    }

    // Method to delete a student by PRN
    private void deleteStudent() {
        // Creating Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Prompting user for PRN to delete
        System.out.print("Enter PRN to delete: ");
        // Reading PRN from user input
        int deletePRN = scanner.nextInt();

        // Iterating through the array to find the student with the specified PRN
        for (int i = 0; i < count; i++) {
            // Checking if the PRN matches
            if (studentArray[i].getPrn() == deletePRN) {
                // Moving all elements after this position one step back
                System.arraycopy(studentArray, i + 1, studentArray, i, count - i - 1);
                // Decreasing the count of students in the array
                count--;
                // Displaying success message
                System.out.println("Student deleted successfully!\n");
                // Exiting the method
                return;
            }
        }

        // Displaying a message if no student with the specified PRN is found
        System.out.println("Student with PRN " + deletePRN + " not found.\n");
    }
}
