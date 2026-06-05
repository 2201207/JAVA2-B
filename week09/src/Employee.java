abstract public class Employee extends Person implements Symbolic{
    private String employeeID;

    public Employee(String name, Date birthDay, String employeeID) {
        super(name, birthDay);
        this.employeeID = employeeID;
    }

    abstract public int basicSalary();
    abstract public int bonus();

    public int salary()  {
        return basicSalary() + bonus();
    }

    public int tax() {
        int tax;
        if (this instanceof Temporary)
            tax = (int) (basicSalary() * (6.6f / 100));
        else {
            if (basicSalary() <= 2000000 )
                tax = (int) (basicSalary() * (6.6f / 100));
            else if (basicSalary() <= 4000000)
                tax = (int) (basicSalary() * (7.3f / 100));
            else
                tax = (int) (basicSalary() * (8.5f / 100));
        }
        return tax;
    }

    public int gross( ) {
        return salary() -tax();
    }

    @Override
    public String toString() {
        return String.format("%6s %s", employeeID, super.toString());

    }
}