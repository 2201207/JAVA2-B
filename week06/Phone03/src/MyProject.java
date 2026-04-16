import java.io.IOException;

public interface MyProject {

    default void error(String message) throws IOException {
        System.err.printf("ERROR : %s", message);
        System.in.read();
    }
}