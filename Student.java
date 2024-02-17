// Student.java
// Student class to represent a student with PRN, Name, Date of Birth, and Marks
public class Student {
    // Private fields for PRN, Name, Date of Birth, and Marks
    private int prn;
    private String name;
    private String dob;
    private int marks;

    // Constructor to initialize a Student object with given values
    public Student(int prn, String name, String dob, int marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    // Getter method for PRN
    public int getPrn() {
        return prn;
    }

    // Getter method for Name
    public String getName() {
        return name;
    }

    // Getter method for Date of Birth
    public String getDob() {
        return dob;
    }

    // Getter method for Marks
    public int getMarks() {
        return marks;
    }

    // Setter method for Marks
    public void setMarks(int marks) {
        this.marks = marks;
    }

    // Override toString method to provide a string representation of the object
    @Override
    public String toString() {
        return "PRN: " + prn + ", Name: " + name + ", DoB: " + dob + ", Marks: " + marks;
    }
}