public class Contract extends Employee{

    public Contract(String name, Date birthDay, String employeeID) {
        super(name, birthDay, employeeID);
    }

    @Override
    public int basicSalary() {
        return 2000000;
    }

    @Override
    public int bonus() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s %c급-%c호 %2d %,6d원 %,9d원 %,9d원 %,9d원 %,7d원 %,9d원 %s",
                super.toString(), 'X', 'X', 0, 0, basicSalary(), bonus(),salary(), tax(), gross(), "계약직");
    }
}