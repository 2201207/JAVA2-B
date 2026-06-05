import java.util.Scanner;

public class Company {
    private Stack employeeStack;

    public Company(int capacity) {
        employeeStack = new Stack(capacity);
    }

    public void addEmployee(Employee emp) {
        employeeStack.push(emp);
    }

    public void processDynamicInput(Scanner sc) {
        for (int i = 0; i < employeeStack.size(); i++) {
            Employee e = employeeStack.get(i);

            if (e.getName().equals("이름없음")) continue;

            if (e instanceof Temporary) {
                Temporary t = (Temporary) e;
                while (true) {
                    System.out.printf("[일용직] %s님의 일당 입력 : ", t.getName());
                    int wage = sc.nextInt();
                    if (wage >= 25000 && wage <= 95000) {
                        System.out.printf("[일용직] %s님의 작업 일수 입력 : ", t.getName());
                        int days = sc.nextInt();
                        t.setWorkData(wage, days);
                        System.out.println();
                        break;
                    } else {
                        System.out.println("ERROR : 일당 범위 오류 (25,000 ~ 95,000원)\n");
                    }
                }
            } else if (e instanceof Salesman) {
                Salesman s = (Salesman) e;
                System.out.printf("[영업직] %s님의 판매 금액 입력 : ", s.getName());
                long sales = sc.nextLong();
                System.out.printf("[영업직] %s님의 커미션 비율 입력 : ", s.getName());
                double rate = sc.nextDouble();
                s.setSalesData(sales, rate);
                System.out.println();
            }
        }
    }

    public void calculateAndSort() {
        for (int i = 0; i < employeeStack.size(); i++) {
            employeeStack.get(i).calculatePay();
        }
        employeeStack.sort();
    }

    public void printPayroll() {
        long totalNetPay = 0;
        System.out.println("\n                                           경복주식회사 급여 대장");
        System.out.println("********************************************************************************************************************************");
        System.out.println("사번      이름                        급-호   day      일당      기본급    인센티브      커미션      급여액      세금      지급액   비고");
        System.out.println("********************************************************************************************************************************");

        for (int i = 0; i < employeeStack.size(); i++) {
            Employee e = employeeStack.get(i);
            totalNetPay += e.netPay;

            String gradeStep = " 0급-0호";
            int day = 0, dailyWage = 0, incentive = 0, commission = 0;

            if (e instanceof Regular) gradeStep = String.format("%2d급-%d호", ((Regular) e).grade, ((Regular) e).step);
            if (e instanceof Temporary) { day = ((Temporary) e).days; dailyWage = ((Temporary) e).dailyWage; }
            if (e instanceof Manager) incentive = ((Manager) e).allowance;
            if (e instanceof Researcher) incentive = ((Researcher) e).researchAllowance; // 연구직 30만원 인센티브 표시
            if (e instanceof Salesman) commission = ((Salesman) e).commission;

            System.out.printf("%s %-4s %s %s %3d %,10d원 %,10d원 %,10d원 %,10d원 %,10d원 %,8d원 %,9d원  %s\n",
                    e.empId, e.getName(), e.getBirthday().toString(), gradeStep, day, dailyWage, e.basePay, incentive, commission, e.totalPay, e.tax, e.netPay, e.jobType);
        }
        System.out.println("********************************************************************************************************************************");
        System.out.printf("                                                 지급액 합계 :          %,d 원\n", totalNetPay);
        System.out.println("********************************************************************************************************************************\n");

        System.out.println("                        영업직 사원 커미션 산출 내역");
        System.out.println("*****************************************************************************");
        System.out.println("사번         이름                  판매 실적        요율       커미션 금액");
        System.out.println("*****************************************************************************");
        for (int i = 0; i < employeeStack.size(); i++) {
            Employee e = employeeStack.get(i);
            if (e instanceof Salesman && !e.getName().equals("이름없음")) {
                Salesman s = (Salesman) e;
                System.out.printf("%s %-4s %s %,14d원  %4.1f %%  %,10d\n",
                        s.empId, s.getName(), s.getBirthday().toString(), s.sales, s.commRate, s.commission);
            }
        }
        System.out.println("*****************************************************************************");
    }
}