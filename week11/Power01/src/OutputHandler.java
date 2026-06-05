import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class OutputHandler {

    protected void report(String fileName, ArrayList<Customer> customers) {
        try {
            PrintWriter printWriter = new PrintWriter(fileName, StandardCharsets.UTF_8);
            PrintWriter monitor = new PrintWriter(System.out);
            header(monitor);
            header(printWriter);

            for (int i = 0; i < customers.size(); i++) {
                printWriter.println(customers.get(i));
                monitor.println(customers.get(i));
            }
            line(printWriter, 60);
            line(monitor, 60);
            printWriter.close();
            monitor.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void header(PrintWriter printWriter) {
        line(printWriter, 60);
        printWriter.println(" 고객번호  이름  사용량  사용금액  세금   납부금액   비고 ");
        line(printWriter, 60);
    }

    private void line(PrintWriter printWriter, int count) {
        for (int i = 0; i < count; i++)
            printWriter.print("*");
        printWriter.println();
    }
}