public class Salary {
    public int getBaseSalary(int grade) {
        switch (grade) {
            case 1: return 6000000;
            case 2: return 5000000;
            case 3: return 4589000;
            case 4: return 3689000;
            case 5: return 3235000;
            case 6: return 2589000;
            case 7: return 2123000;
            default: return 0;
        }
    }
    public String getGradeName(int grade) {
        switch (grade) {
            case 1: return "상무";
            case 2: return "이사";
            case 3: return "부장";
            case 4: return "차장";
            case 5: return "과장";
            case 6: return "대리";
            case 7: return "사원";
            default: return "";
        }
    }
    public int getBasicAllowance(int grade, int step) {
        if (grade >= 5 && grade <= 7) {
            return step * 100000;
        } else if (grade >= 3 && grade <= 4) {
            return step * 150000;
        }
        return 0;
    }
    public int getManagerBonus(int grade, int baseSalary) {
        if (grade >= 3 && grade <= 4) {
            int bonus = (int)(baseSalary * 0.1);
            return bonus / 1000 * 1000;
        }
        return 0;
    }
    public int getTax(int payment) {
        double rate;
        if (payment <= 2000000) {
            rate = 0.045;
        } else if (payment < 4000000) {
            rate = 0.084;
        } else if (payment < 6000000) {
            rate = 0.106;
        } else {
            rate = 0.123;
        }
        return (int)(payment * rate);
    }
}