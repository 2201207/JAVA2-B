public class FastFood {
    private String name;
    private int radius;
    private final float PI;

    public FastFood() {
        this.PI = 3.141592f;
    }

    public FastFood(String name, int radius) {
        this.name = name;
        this.radius = radius;
        this.PI = 3.141592f;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    public float area() {
        return  PI * radius * radius;
    }
    @Override
    public String toString() {
        return String.format("이름 : %s, 반지름 : %d Cm, 면적 : %.2f\u33a0",
                name, radius, area());
    }
}