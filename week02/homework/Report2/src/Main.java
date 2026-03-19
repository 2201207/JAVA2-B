public class Main {
    public static void main(String[] args) {

        Movie movie1 = new Movie("헤라클레스", "레니 할린", 2014, "켈란 루츠", 6.9);
        Movie movie2 = new Movie("노아", "대런 아로노프스키", 2004, "러셀 크로우", 7.3);

        movie2.rankPoint = 8.2;

        System.out.println("[영화 정보 전체 출력]");
        movie1.printMovieInfo();
        movie2.printMovieInfo();

        System.out.println("[movie1 감독 이름만 출력]");
        String[] directorName = movie1.director.split(" ");
        System.out.println(directorName[1]);
    }
}