import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InputHandler {

    public ArrayList<Customer> readData(File file) {
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(file);
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim().replaceAll(",", "");
                StringTokenizer tokenizer = new StringTokenizer(line);
                String customID = tokenizer.nextToken();
                String name = tokenizer.nextToken();
                String usage = tokenizer.nextToken();
                Customer customer;
                if (customID.charAt(0) == '9')
                    customer = new Special();
                else
                    customer = new Normal();
                customer.setName(name);
                customer.setCustomID(customID);
                customer.setPowerUsage(Integer.parseInt(usage));
                customers.add(customer);
            }
            reader.close();
            if (customers.isEmpty()) {
                System.out.println("데이터가 없습니다");
                System.exit(-1);
            } else {
                System.out.printf("%,d개의 데이터를 읽었습니다.\n", customers.size());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return customers;
    }
}