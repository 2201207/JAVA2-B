public class Person {
    private String name;
    private int height;
    private float weight;
    private Date birthday;
    private Address address;

    public Person(String name, int height, float weight, Date birthday, Address address) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthday = birthday;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s는 키가 %dCm이고, 몸무게는 %.1fKg이고, 나이는 %s 입니다." +
                        "\n주소 %s",
                name, height, weight, birthday, address);
    }
}