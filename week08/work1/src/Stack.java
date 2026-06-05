import java.util.Arrays;

public class Stack {
    private Employee[] elements;
    private int top;

    public Stack(int capacity) {
        elements = new Employee[capacity];
        top = -1;
    }

    public void push(Employee emp) {
        if (top < elements.length - 1) elements[++top] = emp;
    }

    public Employee pop() {
        return (top >= 0) ? elements[top--] : null;
    }

    public int size() { return top + 1; }

    public Employee get(int index) {
        return (index >= 0 && index <= top) ? elements[index] : null;
    }

    public void sort() {
        Arrays.sort(elements, 0, top + 1);
    }
}