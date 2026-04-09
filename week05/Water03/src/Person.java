public class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%3s", name);
    }
}