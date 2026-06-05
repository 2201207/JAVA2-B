import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employees;

    public Company(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void sortByGrade() {
        for (int i = 0; i < employees.size() - 1; i++) {
            for (int j = i + 1; j < employees.size(); j++) {
                Employee first = employees.get(i);
                Employee second = employees.get(j);

                if (first.getSortGrade() > second.getSortGrade()) {
                    employees.set(i, second);
                    employees.set(j, first);
                }
            }
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}