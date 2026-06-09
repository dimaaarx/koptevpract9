public class MyNumber implements Comparable<MyNumber> {
    private int value;

    public MyNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(MyNumber other) {
        return this.value - other.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
