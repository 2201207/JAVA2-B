public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }


    public String toString() {
        return "책 제목 : " + title + ", 저자 : " + author;
    }
}