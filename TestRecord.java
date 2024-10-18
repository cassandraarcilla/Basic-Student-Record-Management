import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int studentNumId;
    private String names;
    private int age;
    private String grade;

    public Student(int studentNumId, String names, int age, String grade) {
        this.studentNumId = studentNumId;
        this.names = names;
        this.age = age;
        this.grade = grade;
    }

    public int getStudentNumId() {
        return studentNumId;
    }

    public void setStudentNumId(int studentNumId) {
        this.studentNumId = studentNumId;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

public class TestRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("Enter student ID, name, age, grade ('exit' to quit):");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            String[] parts = input.split(" ");
            int studentNumId = Integer.parseInt(parts[0]);
            String name = parts[1];
            int age = Integer.parseInt(parts[2]);
            String grade = parts[3];

            Student student = new Student(studentNumId, name, age, grade);
            students.add(student);
        }

        System.out.println("List of students:");
        for (Student student : students) {
            System.out.println("ID: " + student.getStudentNumId() + ", Name: " + student.getNames() +
                    ", Age: " + student.getAge() + ", Grade: " + student.getGrade());
        }

        scanner.close();
    }
}