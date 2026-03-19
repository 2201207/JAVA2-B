public class Movie {

    String title;
    String director;
    int open;
    String mainActor;
    double rankPoint;

    public Movie(String title, String director, int open, String mainActor, double rankPoint) {
        this.title = title;
        this.director = director;
        this.open = open;
        this.mainActor = mainActor;
        this.rankPoint = rankPoint;
    }

    public void printMovieInfo() {
        System.out.println("제목 : " + title);
        System.out.println("감독 : " + director);
        System.out.println("개봉 : " + open);
        System.out.println("주연 : " + mainActor);
        System.out.println("평점 : " + rankPoint);
        System.out.println("--------------------");
    }
}