import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class ExcelHandler {
    private DataFormatter formatter;

    public ExcelHandler() {
        formatter = new DataFormatter();
    }

    public ArrayList<Employee> readExcel(String fileName) {
        ArrayList<Employee> employees = new ArrayList<Employee>();

        try {
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XSSFWorkbook workbook = new XSSFWorkbook(bis);

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                String employeeID = readData(row, 0);
                String name = readData(row, 1);

                if (employeeID.equals("") || name.equals("")) continue;

                int year = readInt(row, 2);
                int month = readInt(row, 3);
                int day = readInt(row, 4);

                String type = readData(row, 5).toLowerCase();

                int grade = readInt(row, 6);
                int step = readInt(row, 7);
                int workDay = readInt(row, 8);
                int dailyPay = readInt(row, 9);
                int performancePay = readInt(row, 10);
                int stockOption = readInt(row, 11);

                Employee employee;

                if (type.equals("regular") || type.equals("정규직") ||
                        type.equals("관리직") || type.equals("임원직")) {
                    employee = new RegularEmployee(employeeID, name, year, month, day,
                            grade, step, performancePay, stockOption);
                } else if (type.equals("temporary") || type.equals("일용직") ||
                        type.equals("일당제")) {
                    employee = new TemporaryEmployee(employeeID, name, year, month, day,
                            workDay, dailyPay);
                } else if (type.equals("contract") || type.equals("계약직")) {
                    employee = new ContractEmployee(employeeID, name, year, month, day);
                } else {
                    if (grade > 0) {
                        employee = new RegularEmployee(employeeID, name, year, month, day,
                                grade, step, performancePay, stockOption);
                    } else if (workDay > 0 || dailyPay > 0) {
                        employee = new TemporaryEmployee(employeeID, name, year, month, day,
                                workDay, dailyPay);
                    } else {
                        employee = new ContractEmployee(employeeID, name, year, month, day);
                    }
                }

                employees.add(employee);
            }

            workbook.close();
            bis.close();

            System.out.println(employees.size() + "명의 데이터를 읽었습니다.");

        } catch (Exception e) {
            System.out.println("Excel 읽기 오류 : " + e.getMessage());
        }

        return employees;
    }

    public void writeExcel(String fileName, ArrayList<Employee> employees) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("직원 급여 현황표");

            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderTop(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);

            CellStyle bodyStyle = workbook.createCellStyle();
            bodyStyle.setBorderTop(BorderStyle.THIN);
            bodyStyle.setBorderBottom(BorderStyle.THIN);
            bodyStyle.setBorderLeft(BorderStyle.THIN);
            bodyStyle.setBorderRight(BorderStyle.THIN);
            bodyStyle.setAlignment(HorizontalAlignment.CENTER);

            String[] titles = {
                    "사번", "이름", "년", "월", "일",
                    "직급", "직급명", "호봉", "day", "일당",
                    "기본급", "기본수당", "관리/성과", "스톡옵션",
                    "급여액", "세금", "지급액", "기타"
            };

            Row titleRow = sheet.createRow(0);

            for (int i = 0; i < titles.length; i++) {
                Cell cell = titleRow.createCell(i);
                cell.setCellValue(titles[i]);
                cell.setCellStyle(headerStyle);
            }

            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                Row row = sheet.createRow(i + 1);

                writeCell(row, 0, employee.getEmployeeID(), bodyStyle);
                writeCell(row, 1, employee.getName(), bodyStyle);
                writeCell(row, 2, employee.getYear(), bodyStyle);
                writeCell(row, 3, employee.getMonth(), bodyStyle);
                writeCell(row, 4, employee.getDay(), bodyStyle);

                writeCell(row, 5, zeroBlank(employee.getGrade()), bodyStyle);
                writeCell(row, 6, employee.getGradeName(), bodyStyle);
                writeCell(row, 7, zeroBlank(employee.getStep()), bodyStyle);
                writeCell(row, 8, zeroBlank(employee.getWorkDay()), bodyStyle);
                writeCell(row, 9, moneyBlank(employee.getDailyPay()), bodyStyle);

                writeCell(row, 10, money(employee.getBaseSalary()), bodyStyle);
                writeCell(row, 11, moneyBlank(employee.getBasicAllowance()), bodyStyle);
                writeCell(row, 12, moneyBlank(employee.getManageOrPerformancePay()), bodyStyle);
                writeCell(row, 13, moneyBlank(employee.getStockOption()), bodyStyle);

                writeCell(row, 14, money(employee.getPayment()), bodyStyle);
                writeCell(row, 15, money(employee.getTax()), bodyStyle);
                writeCell(row, 16, money(employee.getRealPayment()), bodyStyle);
                writeCell(row, 17, employee.getEtc(), bodyStyle);
            }
            for (int i = 0; i < titles.length; i++) {
                sheet.autoSizeColumn(i);
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            workbook.write(bos);

            bos.close();
            workbook.close();

            System.out.println("결과 Excel 파일 생성 성공 : " + fileName);

        } catch (Exception e) {
            System.out.println("Excel 쓰기 오류 : " + e.getMessage());
        }
    }

    private String readData(Row row, int index) {
        Cell cell = row.getCell(index);
        if (cell == null) return "";
        return formatter.formatCellValue(cell).trim();
    }

    private int readInt(Row row, int index) {
        String data = readData(row, index);

        if (data.equals("")) return 0;

        data = data.replace(",", "");
        data = data.replace("원", "");
        data = data.trim();

        return (int)Double.parseDouble(data);
    }

    private void writeCell(Row row, int index, String data, CellStyle style) {
        Cell cell = row.createCell(index);
        cell.setCellValue(data);
        cell.setCellStyle(style);
    }

    private void writeCell(Row row, int index, int data, CellStyle style) {
        Cell cell = row.createCell(index);
        cell.setCellValue(data);
        cell.setCellStyle(style);
    }

    private String money(int value) {
        return String.format("%,d원", value);
    }

    private String moneyBlank(int value) {
        if (value == 0) return "";
        return money(value);
    }

    private String zeroBlank(int value) {
        if (value == 0) return "";
        return String.valueOf(value);
    }
}