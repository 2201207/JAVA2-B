public class Date {
    // 다이어그램 요구사항에 맞춰 마이너스 기호는 private으로 선언
    private int year;
    private int month;
    private int day;

    // 생성자 및 날짜 유효성 검사
    public Date(int year, int month, int day) {
        if (isValid(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            System.out.println("오류: " + year + "년 " + month + "월 " + day + "일은 존재하지 않는 날짜입니다.");
        }
    }

    // 연도 수정 기능
    public void setYear(int year) {
        this.year = year;
    }

    // 날짜가 실제 달력에 존재하는지 확인하는 내부 로직
    private boolean isValid(int y, int m, int d) {
        if (m < 1 || m > 12) return false;
        int[] maxDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 윤년 계산 적용
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
            maxDays[2] = 29;
        }

        if (d < 1 || d > maxDays[m]) return false;
        return true;
    }

    // 다이어그램 요구사항에 맞춰 플러스 기호는 public으로 선언
    public String toString() {
        if (year == 0) {
            return "유효하지 않은 날짜 객체";
        }
        return year + "년 " + month + "월 " + day + "일";
    }
}
