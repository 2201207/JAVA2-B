public class Staff extends Regular{

    public Staff(String name, Date birthDay, String employeeID, int grade, int step) {
        super(name, birthDay, employeeID, grade, step);
    }

    @Override
    public int bonus() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s %,9d원 %,9d원 %,7d원 %,9d원 %s",
                super.toString(), bonus(), salary(), tax(), gross(), "정규직");
    }
}