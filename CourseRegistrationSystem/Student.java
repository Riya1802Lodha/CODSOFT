import java.util.ArrayList;
import java.util.List;

// Class representing a Student
class Student {
    private String studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        course.registerStudent();
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        course.deregisterStudent();
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID +
                "\nName: " + name +
                "\nRegistered Courses: " + registeredCourses.size() + "\n";
    }
}
