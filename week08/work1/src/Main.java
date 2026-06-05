import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Company company = new Company(20);


        company.addEmployee(new Regular("2201207", "김현준", new Date(2010, 3, 7), 2, 3));
        company.addEmployee(new Temporary("123456", "경복대", new Date(1993, 10, 5)));
        company.addEmployee(new Salesman("124567", "한송이", new Date(2011, 4, 19), 3, 4));
        company.addEmployee(new Temporary("456213", "이대한", new Date(1999, 5, 13)));
        company.addEmployee(new Salesman("424561", "최명길", new Date(2012, 4, 20), 3, 2));
        company.addEmployee(new Salesman("124655", "정통파", new Date(2013, 12, 20), 2, 3));


        company.addEmployee(new Researcher("348967", "진접읍", new Date(1987, 6, 22), 4, 5));

        company.addEmployee(new Manager("245778", "한민국", new Date(2012, 12, 20), 3, 1));
        company.addEmployee(new Regular("348988", "코로나", new Date(2011, 8, 10), 1, 4));
        company.addEmployee(new Manager("345678", "한국인", new Date(2012, 7, 20), 1, 1));


        company.addEmployee(new Regular());


        company.processDynamicInput(sc);
        company.calculateAndSort();
        company.printPayroll();

        sc.close();
    }
}