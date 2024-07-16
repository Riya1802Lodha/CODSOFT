import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class representing the Course Registration System
public class CourseRegistrationSystem {
    private List<Course> courses;
    private List<Student> students;

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    // Method to add a new course to the system
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Method to display all available courses
    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    // Method to register a student for a course
    public void registerStudentForCourse(String studentID, String courseCode) {
        Student student = findStudent(studentID);
        Course course = findCourse(courseCode);

        if (student == null) {
            System.out.println("Student with ID " + studentID + " not found.");
            return;
        }

        if (course == null) {
            System.out.println("Course with code " + courseCode + " not found.");
            return;
        }

        if (course.getRegisteredStudents() >= course.getCapacity()) {
            System.out.println("Course " + course.getTitle() + " is full. Cannot register.");
            return;
        }

        student.registerCourse(course);
        System.out.println("Student " + student.getName() + " registered successfully for course " + course.getTitle() + ".");
    }

    // Method to drop a course for a student
    public void dropCourseForStudent(String studentID, String courseCode) {
        Student student = findStudent(studentID);
        Course course = findCourse(courseCode);

        if (student == null) {
            System.out.println("Student with ID " + studentID + " not found.");
            return;
        }

        if (course == null) {
            System.out.println("Course with code " + courseCode + " not found.");
            return;
        }

        if (!student.getRegisteredCourses().contains(course)) {
            System.out.println("Student " + student.getName() + " is not registered for course " + course.getTitle() + ".");
            return;
        }

        student.dropCourse(course);
        System.out.println("Student " + student.getName() + " dropped course " + course.getTitle() + " successfully.");
    }

    // Helper method to find a student by ID
    private Student findStudent(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    // Helper method to find a course by course code
    private Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CourseRegistrationSystem registrationSystem = new CourseRegistrationSystem();

        // Sample courses
        Course javaCourse = new Course("COMP101", "Introduction to Java Programming", "Learn basics of Java programming language", 30, "Mon-Wed-Fri, 10:00 AM - 11:30 AM");
        Course algoCourse = new Course("COMP201", "Algorithm Design", "Study advanced algorithms and data structures", 25, "Tue-Thu, 2:00 PM - 3:30 PM");

        registrationSystem.addCourse(javaCourse);
        registrationSystem.addCourse(algoCourse);

        // Sample students
        Student student1 = new Student("S001", "Alice");
        Student student2 = new Student("S002", "Bob");

        registrationSystem.students.add(student1);
        registrationSystem.students.add(student2);

        // Register students for courses
        registrationSystem.registerStudentForCourse("S001", "COMP101");
        registrationSystem.registerStudentForCourse("S002", "COMP101");
        registrationSystem.registerStudentForCourse("S001", "COMP201");

        // Display available courses
        registrationSystem.displayCourses();

        // Drop a course for a student
        registrationSystem.dropCourseForStudent("S001", "COMP101");

        // Display student information after registration
        for (Student student : registrationSystem.students) {
            System.out.println(student);
        }
    }
}
