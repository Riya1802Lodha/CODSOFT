// Class representing a Course
class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int registeredStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public void registerStudent() {
        registeredStudents++;
    }

    public void deregisterStudent() {
        registeredStudents--;
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode +
                "\nTitle: " + title +
                "\nDescription: " + description +
                "\nCapacity: " + capacity +
                "\nSchedule: " + schedule +
                "\nRegistered Students: " + registeredStudents + "\n";
    }
}
