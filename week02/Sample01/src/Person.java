public class Person {
    // State (상태) - 명사
    private String name;
    private int age;
    private boolean gender; // true -남, false - 여
    private boolean isMaried;
    private int children;

    // 생성자


    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, boolean gender, boolean isMaried, int children) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isMaried = isMaried;
        this.children = children;
    }

    // Method


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public boolean isGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public boolean isMaried() {
        return isMaried;
    }
    public void setMaried(boolean maried) {
        isMaried = maried;
    }
    public int getChildren() {
        return children;
    }
    public void setChildren(int children) {
        this.children = children;
    }
    @Override
    public String toString() {
        String type = gender ? "남자" : "여자";
        return String.format("나이는 %d살, 이름은 %s이라는 %s가 있습니다.\n" +
                        "이 %s는 결혼을 %s 자식이 %d명이 있습니다.",
                age, name, type, type, isMaried ? "했고" : "안했고", children);
    }
}