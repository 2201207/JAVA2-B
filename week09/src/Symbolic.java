import java.io.IOException;

interface Symbolic {
    int[][] salary = new int[][] {
            {0, 0, 0, 0, 0,  0 },
            {0, 2600000, 2650000, 2700000, 2750000,  2800000 },
            {0, 2600000, 2650000, 2700000, 2750000,  2800000 },
            {0, 2600000, 2650000, 2700000, 2750000,  2800000 },
            {0, 2600000, 2650000, 2700000, 2750000,  2800000 },
            {0, 2600000, 2650000, 2700000, 2750000,  2800000 }
    };



    default void error(String message) throws IOException {
        System.err.println("ERROR : " + message);
        System.in.read();
    }
}