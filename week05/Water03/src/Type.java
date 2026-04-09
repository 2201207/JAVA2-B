public class Type {
    protected String typeName;
    protected int unitPrice;
    protected float taxRate;

    public Type(String typeName, int unitPrice, float taxRate) {
        this.typeName = typeName;
        this.unitPrice = unitPrice;
        this.taxRate = taxRate;
    }

    @Override
    public String toString() {
        return String.format("%3s", typeName);
    }
}