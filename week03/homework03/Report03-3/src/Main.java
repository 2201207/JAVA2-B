public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Member member1 = new Member("본인이름");
        Book book1 = new Book("자바 프로그래밍");
        Book book2 = new Book("자료구조");

        library.registerMember(member1);
        library.stockBook(book1);
        library.stockBook(book2);
        System.out.println("--------------------");

        library.printStatus();
        System.out.println("--------------------");

        library.borrowBook(member1, book1);
        library.printStatus();
        System.out.println("--------------------");

        library.returnBook(member1, book1);
        library.printStatus();
    }
}
