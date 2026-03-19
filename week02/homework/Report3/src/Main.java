import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 본인의 생년월일 입력
        System.out.print("본인의 생년월일을 입력하세요 (연 월 일 띄어쓰기): ");
        int bYear = scanner.nextInt();
        int bMonth = scanner.nextInt();
        int bDay = scanner.nextInt();
        Date myBirth = new Date(bYear, bMonth, bDay);
        System.out.println("내 생일: " + myBirth.toString());
        System.out.println("--------------------");

        // 2. 오늘의 날짜 입력
        System.out.print("오늘의 날짜를 입력하세요 (연 월 일 띄어쓰기): ");
        int tYear = scanner.nextInt();
        int tMonth = scanner.nextInt();
        int tDay = scanner.nextInt();
        Date today = new Date(tYear, tMonth, tDay);
        System.out.println("오늘 날짜: " + today.toString());
        System.out.println("--------------------");

        // 3. 2025년 2월 29일 입력 (오류 발생 테스트)
        System.out.print("오류 테스트를 위한 날짜를 입력하세요 (예: 2025 2 29): ");
        int eYear = scanner.nextInt();
        int eMonth = scanner.nextInt();
        int eDay = scanner.nextInt();
        System.out.print("오류 테스트 - ");
        Date errorDate = new Date(eYear, eMonth, eDay);
        System.out.println("결과: " + errorDate.toString());
        System.out.println("--------------------");

        // 4. 년도만을 수정 (오늘 날짜 객체의 연도를 입력받아 수정)
        System.out.print("수정할 연도를 입력하세요: ");
        int newYear = scanner.nextInt();
        today.setYear(newYear);
        System.out.println("연도 수정 후 날짜: " + today.toString());

        scanner.close();
    }
}