import java.io.IOException;

public interface MyProject {
    double A = 90.0;
    double B = 80.0;
    double C = 70.0;
    double D = 60.0;

    default boolean isValid(int score) {
        return score >= 0 && score <= 100;
    }

    default boolean isValid1(int score) {
        return score >= 0 && score <= 20;
    }

    default boolean isValid2(int score) {
        return score == 1 || score == 2;
    }

    default void error(String message) throws IOException {
        System.err.print("ERROR : " + message);
        System.in.read();
    }
}