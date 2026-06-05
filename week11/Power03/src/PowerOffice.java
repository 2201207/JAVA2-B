import java.util.ArrayList;

public class PowerOffice {
    private ArrayList<Customer> customers;

    public PowerOffice(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    protected void sortByCharge() {
        for (int i = 0; i < customers.size() - 1; i++) {
            for (int j = i + 1; j < customers.size(); j++) {
                if (customers.get(i).charge() < customers.get(j).charge()) {
                    Customer customer = customers.get(i);
                    customers.set(i, customers.get(j));
                    customers.set(j, customer);
                }
            }
        }
    }
}