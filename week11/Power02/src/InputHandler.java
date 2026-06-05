import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class InputHandler {

    public ArrayList<Customer> readData(File file) {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim().replaceAll(",", "");
                String[] datas = line.split(" ");
                Customer customer;
                if (datas[0].charAt(0) == '9') {
                    customer = new Special(datas[1], datas[0], Integer.parseInt(datas[2]));
                } else {
                    customer = new Normal(datas[1], datas[0], Integer.parseInt(datas[2]));
                }
                customers.add(customer);
            }
            reader.close();
            if (customers.isEmpty()) {
                System.out.println("데이터가 없습니다");
                System.exit(-1);
            } else {
                System.out.printf("%,d 개의 데이터를 읽었습니다.\n", customers.size());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return customers;
    }
}