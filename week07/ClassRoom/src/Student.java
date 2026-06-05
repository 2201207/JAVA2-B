import java.io.IOException;
import java.util.ArrayList;

abstract public class Student extends Person implements Project, MyProject{
    protected ArrayList<Part> parts;

    public Student(String studentID, String name) {
        super(studentID, name);
        this.parts = new ArrayList<>();
        parts.add(new Part("중간고사"));
        parts.add(new Part("기말고사"));
    }

    protected void inputData() throws IOException {
        for (int i = 0; i < parts.size(); i++)
            parts.get(i).inputData(getName());
    }

    protected String partsNameList() {
        String result = "";
        for (int i = 0; i < parts.size(); i++)
            result += String.format("  %s  ", parts.get(i).getPartName());
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s %s", super.toString(), partList());
    }
}