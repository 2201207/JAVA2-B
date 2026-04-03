public class Grade {
    private char grade;
    private int salary;

    public Grade(char grade, int salary) {
        this.grade = grade;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public char getGrade() {
        return grade;
    }
}