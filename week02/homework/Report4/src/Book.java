public class Book {
    // 다이어그램의 마이너스 기호에 맞춰 접근을 제한하는 변수 선언
    private String title;
    private String author;

    // 생성자
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // 다이어그램의 플러스 기호에 맞춰 문자열을 반환하는 메서드 재정의
    public String toString() {
        return "책 제목 : " + title + ", 저자 : " + author;
    }
}