public class School extends Customer{
    public School(String name, String waterNo) {
        super(name, waterNo);
        type = new Type("학교기", 35, 1.8f);
    }
}