//Basic Student Record Management 

import java.util.ArrayList;
import java.util.Iterator;
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

class StudentDatabase {
    private List<Student> students;

    public StudentDatabase() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(int studentNumId, String names, int age, String grade) {
        for (Student student : students) {
            if (student.getStudentNumId() == studentNumId) {
                student.setNames(names);
                student.setAge(age);
                student.setGrade(grade);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(int studentNumId) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentNumId() == studentNumId) {
                iterator.remove();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public Student getStudent(int studentNumId) {
        for (Student student : students) {
            if (student.getStudentNumId() == studentNumId) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}

public class Record {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDatabase studentData = new StudentDatabase();

        try {
            while (true) {
                System.out.println("====================================");
                System.out.println("\t\t Menu:");
                System.out.println("\t1. Add Student");
                System.out.println("\t2. View/Search");
                System.out.println("\t3. Edit");
                System.out.println("\t4. Delete");
                System.out.println("\t5. View ");
                System.out.println("\t6. Exit");
                System.out.println("\t7. About");
                System.out.println("===================================");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    // Add Student
                    case 1:
                        System.out.print("Enter Student ID: ");
                        int studentNumId = scanner.nextInt();

                        scanner.nextLine();
                        System.out.print("Enter Names: ");
                        String names = scanner.nextLine();

                        System.out.print("Enter Age: ");
                        int age = scanner.nextInt();

                        scanner.nextLine();
                        System.out.print("Enter Grade: ");
                        String grade = scanner.nextLine();

                        Student student = new Student(studentNumId, names, age, grade);
                        studentData.addStudent(student);
                        System.out.println("Student added!");
                        break;
                    // View
                    case 2:
                        System.out.print("Enter Student Number: ");
                        int searchId = scanner.nextInt();
                        Student foundStudent = studentData.getStudent(searchId);

                        if (foundStudent != null) {
                            System.out.println("Student found:");
                            System.out.println("ID: " + foundStudent.getStudentNumId());

                            System.out.println("Names: " + foundStudent.getNames());

                            System.out.println("Age: " + foundStudent.getAge());

                            System.out.println("Grade: " + foundStudent.getGrade());
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    // Edit
                    case 3:
                        System.out.print("Enter Student Number: ");
                        int editId = scanner.nextInt();
                        scanner.nextLine();

                        Student editStudent = studentData.getStudent(editId);
                        if (editStudent != null) {
                            System.out.print("Enter new names: ");
                            String newNames = scanner.nextLine();

                            System.out.print("Enter new age: ");
                            int newAge = scanner.nextInt();

                            scanner.nextLine();
                            System.out.print("Enter new grade: ");
                            String newGrade = scanner.nextLine();

                            studentData.updateStudent(editId, newNames.isEmpty() ? editStudent.getNames() : newNames,
                                    newAge == 0 ? editStudent.getAge() : newAge,
                                    newGrade.isEmpty() ? editStudent.getGrade() : newGrade);
                            System.out.println("Student updated successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    // Delete
                    case 4:
                        System.out.print("Enter Student Number to delete: ");
                        int deleteId = scanner.nextInt();

                        studentData.deleteStudent(deleteId);
                        System.out.println("Student deleted successfully.");
                        break;

                    // View
                    case 5:
                        List<Student> allStudents = studentData.getAllStudents();

                        if (!allStudents.isEmpty()) {
                            System.out.println("All Students:");
                            for (Student s : allStudents) {
                                System.out.println("ID: " + s.getStudentNumId() + ", Names: " + s.getNames());
                            }
                        } else {
                            System.out.println("No students in the list.");
                        }
                        break;

                    // Exit
                    case 6:
                        System.out.println("Thankyou for using");
                        break;

                    // About
                    case 7:
                        System.out.println(
                                "About:This program is used to manage student information. This has a user-friendly interface to make it easy for all users to manage information. This program features viewing, selecting, editing, delete student's data. One of the advancements of this program is the user can quickly select a specific student by inputting the student's ID number, they can have immediate access to the information they need. Overall this program is a tool for managing student data/information.");
                        return;

                    default:
                        System.out.println("Invalid ");
                }
            }
        } finally {
            scanner.close();
        }
    }
}