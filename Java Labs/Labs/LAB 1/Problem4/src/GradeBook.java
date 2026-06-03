import Student.Student;
import java.util.Random;

public class GradeBook {
    Student[] students = new Student[10]; // List of Student
    private int size = 11;
    String[] frequency = new String[size];

    int max = Integer.MIN_VALUE, counter = 0, min = Integer.MAX_VALUE, idLowestStudent, idHighestStudent;
    char lowestName, highestName, name = 'A';
    double sum = 0;

    public GradeBook() {
        Random rand = new Random();

        // Create elements of list Students
        for(int i = 0; i < students.length; i++){
            students[i] = new Student(rand.nextInt(100), name,3);
            name++;
        }
    }

    public void displayMessage(Course course){
        System.out.println("Welcome to Grade Book for " +  course.getName());
    }

    public void displayGreatReport(){
        System.out.println("Class average is: " + detetrmineClassAverage(sum,counter));
        System.out.println("Lowest grade is: " + min + " (Student " + lowestName + ",id: " + idLowestStudent + ")");
        System.out.println("Highest grade is: " + max + " (Student " + highestName + ",id: " + idHighestStudent + ")");

        outputBarChart(frequency);
    }

    private void outputBarChart(String[] frequency){
        System.out.println("Grade distribution: ");


        for(int i = 0; i < frequency.length; i++){
            if(i == frequency.length - 1){
                System.out.println(i*10 +": " + frequency[i]);
            }
            System.out.println(i*10 + "-" + (i*10 +9) + ": " + frequency[i]);
        }
    }

    private double detetrmineClassAverage(double sum, int counter){
        return sum / counter;
    }

    public class Course {
        private String name, description, prerequisites;
        private int amountOfCredits;

        public Course(String name, String description, String prerequisites, int amountOfCredits) {
            this.name = name;
            this.description = description;
            this.prerequisites = prerequisites;
            this.amountOfCredits = amountOfCredits;
        }

        public Course(){}

        public String getName() {return name;}
        public String getDescription() {return description;}
        public String getPrerequisites() {return prerequisites;}
        public int getAmountOfCredits() {return amountOfCredits;}

        public void setName(String name) {this.name = name;}
        public void setDescription(String description) {this.description = description;}
        public void setAmountOfCredits(int amountOfCredits) {this.amountOfCredits = amountOfCredits;}
        public void setPrerequisites(String prerequisites) {this.prerequisites = prerequisites;}


    }
}
