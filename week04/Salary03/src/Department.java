public class Department {
    private char departNo;
    private String departName;

    public Department(char departNo, String departName) {
        this.departNo = departNo;
        this.departName = departName;
    }

    public String getDepartName() {
        return departName;
    }

    @Override
    public String toString() {
        return String.format("%3s ", departName);
    }
}