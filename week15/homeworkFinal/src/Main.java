import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final String path = ".\\data\\";
        final String datafile = "employee.xlsx";
        final String resultfile = "employeeOut.xlsx";

        File file = new File(path + datafile);

        if (file.exists()) {
            ExcelHandler excelHandler = new ExcelHandler();
            ArrayList<Employee> employees = excelHandler.readExcel(path + datafile);
            Company company = new Company(employees);
            company.sortByGrade();
            excelHandler.writeExcel(path + resultfile, company.getEmployees());

            System.out.println("급여 계산 프로그램 종료");
        } else {
            System.out.println(path + datafile + " 파일이 없습니다.");
        }
    }
}