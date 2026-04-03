public class Employee {
    int id;
    String name;
    int part;
    boolean special;
    int grade;
    int step;
    int aid;

    int baseSalary;
    int gradeAllow;
    int deptAllow;
    int tax;
    int netPay;
    String deptName;

    public Employee(int id, String name, int part, boolean special, int grade, int step, int aid) {
        this.id = id;
        this.name = name;
        this.part = part;
        this.special = special;
        this.grade = grade;
        this.step = step;
        this.aid = aid;
        calculate();
    }

    private void calculate() {

        int[][] baseTable = {
                {1250000, 1200000, 1150000, 1100000, 1050000},
                {950000, 925000, 900000, 875000, 850000},
                {750000, 725000, 700000, 675000, 650000}
        };
        baseSalary = baseTable[grade - 1][step - 1];

        int[] gradeTable = {300000, 200000, 100000};
        gradeAllow = gradeTable[grade - 1];

        int[] deptTable = {250000, 250000, 350000, 350000, 300000};
        String[] deptNames = {"경리과", "인사과", "영업팀", "생산과", "A/S 팀"};
        deptAllow = deptTable[part - 1];
        deptName = deptNames[part - 1];


        double basicDeduct = baseSalary * 0.03;
        double taxable = (baseSalary + deptAllow + gradeAllow) - (basicDeduct + aid);


        if (special) {
            tax = (int) (baseSalary * 0.0003);
        } else {
            tax = (int) (taxable * 0.0007);
        }


        netPay = (baseSalary + deptAllow + gradeAllow) - tax - aid;
    }

    public void printRow() {
        String specialStr = special ? "O" : "X";
        String gradeStep = grade + " - " + step;
        System.out.printf("%-4s %5d %s   %s   %s  %,10d %,8d %,8d %,8d %,5d %,10d\n",
                name, id, deptName, specialStr, gradeStep, baseSalary, deptAllow, gradeAllow, aid, tax, netPay);
    }
}