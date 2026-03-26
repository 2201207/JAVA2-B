import java.util.ArrayList;

public class Library {
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();

    public void registerMember(Member member) {
        members.add(member);
        System.out.println(member.name + " 회원이 도서관에 가입되었습니다.");
    }

    public void stockBook(Book book) {
        books.add(book);
        System.out.println("도서 입고 완료: " + book.title);
    }

    public void borrowBook(Member member, Book book) {
        if (!book.isBorrowed) {
            book.isBorrowed = true;
            System.out.println(member.name + " 회원이 '" + book.title + "' 도서를 대출했습니다.");
        } else {
            System.out.println("'" + book.title + "' 도서는 현재 대출 중입니다.");
        }
    }

    public void returnBook(Member member, Book book) {
        if (book.isBorrowed) {
            book.isBorrowed = false;
            System.out.println(member.name + " 회원이 '" + book.title + "' 도서를 반납했습니다.");
        } else {
            System.out.println("해당 도서는 대출된 상태가 아닙니다.");
        }
    }

    public void printStatus() {
        System.out.println("--- 도서관 대출 상황 ---");
        for (Book book : books) {
            String status = book.isBorrowed ? "대출 중" : "대출 가능";
            System.out.println("책 제목: " + book.title + " / 상태: " + status);
        }
    }
}
