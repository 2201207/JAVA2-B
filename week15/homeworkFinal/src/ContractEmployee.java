public class ContractEmployee extends Employee {
    public ContractEmployee(String employeeID, String name, int year, int month, int day) {
        super(employeeID, name, year, month, day);
    }

    @Override
    public int getBaseSalary() {
        return 2000000;
    }

    @Override
    public String getEtc() {
        return "계약직";
    }
}