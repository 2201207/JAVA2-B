public class Person {
    private String name;
    private String gender;

    public Person(String name, String gender) {
        this.name = name;
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.equals("M") || gender.equals("m") || gender.equals("남")) {
            this.gender = "남";
        } else {
            this.gender = "여";
        }
    }
}