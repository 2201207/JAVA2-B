public class Grade {

    public String korGrade(int score) {
        switch (score / 10) {
            case 10:
            case 9:
                return "수";
            case 8:
                return "우";
            case 7:
                return "미";
            case 6:
                return "양";
            default:
                return "가";
        }
    }

    public String engMathGrade(int score) {
        switch (score / 5) {
            case 20:
            case 19:
                return "A+";
            case 18:
                return "A0";
            case 17:
                return "B+";
            case 16:
                return "B0";
            case 15:
                return "C+";
            case 14:
                return "C0";
            case 13:
                return "D+";
            case 12:
                return "D0";
            default:
                return "F";
        }
    }

    public String optionGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}