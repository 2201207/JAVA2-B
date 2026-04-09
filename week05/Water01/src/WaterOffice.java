import java.io.IOException;

public class WaterOffice {
    private Customer[] customers;

    public WaterOffice(Customer[] customers) {
        this.customers = customers;
    }

    protected void inputData() throws IOException {
        for (int i = 0; i < customers.length; i++)
            customers[i].inputUsage();
    }

    protected void display() {
        sortByCharge();
        line();
        System.out.println(" 수도번호  이름  구분  사용량   사용금액   세금  남부금액   비고");
        line();
        for (int i = 0; i < customers.length; i++)
            System.out.println(customers[i].toString());
        line();
        System.out.println(total());
        line();
    }

    private String total() {
        return String.format("%s\n%s\n%s\n%s",
                totalUsage(), totalFee(), totalTax(), totalCharge());
    }

    private String totalCharge() {
        int total = 0;
        for (int i = 0; i < customers.length; i++)
            total += customers[i].charge();

        return String.format("납부금액 합계 : %,d원", total);
    }

    private String totalTax() {
        int total = 0;
        for (int i = 0; i < customers.length; i++)
            total += customers[i].tax();

        return String.format("세금 합계 : %,d원", total);
    }

    private String totalFee() {
        int total = 0;
        for (int i = 0; i < customers.length; i++)
            total += customers[i].fee();

        return String.format("사용금액 합계 : %,d원", total);
    }

    private String totalUsage() {
        float total = 0.0f;
        for (int i = 0; i < customers.length; i++)
            total += customers[i].usage;

        return String.format("사용량 합계 : %,.2f", total);
    }

    private void sortByCharge() {
        Customer temp;
        for (int i = 0; i < customers.length - 1; ++i) {
            for (int j = i + 1; j < customers.length; ++j) {
                if (customers[i].charge() < customers[j].charge()) {
                    temp = customers[i];
                    customers[i] = customers[j];
                    customers[j] = temp;
                }
            }
        }
    }

    private void line() {
        for (int i = 0; i < 60; i++)
            System.out.print("*");
        System.out.println();
    }
}