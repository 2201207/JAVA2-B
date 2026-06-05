abstract public class Regular extends Employee{
    private int grade;
    private int step;

    public Regular(String name, Date birthDay, String employeeID, int grade, int step) {
        super(name, birthDay, employeeID);
        this.grade = grade;
        this.step = step;
    }

    @Override
    public int basicSalary() {
        return salary[grade][step];
    }



    @Override
    public String toString() {
        return String.format("%s %d급-%d호 %2d %,6d원 %,9d원",
                super.toString(), grade, step, 0, 0, basicSalary());
    }
}