public class Person {
    private String name;
    private Date birthday;

    public Person() {
        this.name = "이름없음";
        this.birthday = new Date(1900, 1, 1);
    }

    public Person(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return String.format("%4s%s %2d세", name, birthday, birthday.getAge());
    }
}