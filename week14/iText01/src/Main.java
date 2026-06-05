public class Main {
    public static void main(String[] args) {
        String path = ".\\data\\";
        String fileName = "bookinvoice.pdf";

        Book[] books = new Book[] {new Book("JAVA Programming 완전 정복", 22000, 5,
                "9788970502105"),
                new Book("Android Programming 완전정복", 32000, 5,
                        "9788931462869")};
        iTextHandler handler = new iTextHandler();
        handler.makePDF(books, path + fileName);

    }
}