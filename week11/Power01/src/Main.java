import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main implements Constants {
    public static void main(String[] args) throws IOException {
        ArrayList<Customer> customers;

        File file = new File(path + dataFile);
        if (file.exists()) {
            InputHandler handler = new InputHandler();
            customers = handler.readData(file);

            PowerOffice office = new PowerOffice(customers);
            office.sortByCharge();

            OutputHandler outputHandler = new OutputHandler();
            outputHandler.report(path + outputFile, customers);
            Runtime.getRuntime().exec("notepad.exe " + path + outputFile);
        } else {
            System.out.printf("%s File이 존재하지 않아요\n", path + dataFile);
        }
    }
}