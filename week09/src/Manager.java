public class Manager extends Regular{

    public Manager(String name, Date birthDay, String employeeID, int grade, int step) {
        super(name, birthDay, employeeID, grade, step);
    }

    @Override
    public int bonus() {
        int bonus;
        if (basicSalary() <= 1800000)
            bonus = (int) (basicSalary() * (6.0f / 100));
        else if ((basicSalary() <= 2400000))
            bonus = (int) (basicSalary() * (5.0f / 100));
        else
            bonus = (int) (basicSalary() * (4.0f / 100));
        return bonus;
    }

    @Override
    public String toString() {
        return String.format("%s %,9d원 %,9d원 %,7d원 %,9d원 %s",
                super.toString(), bonus(), salary(), tax(), gross(), "관리수당");
    }
}