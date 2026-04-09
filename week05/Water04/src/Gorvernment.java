public class Gorvernment extends Customer{
    public Gorvernment(String name, String waterNo) {
        super(name, waterNo);
        type = new Type("관공서", 35, 1.5f);
    }
}
