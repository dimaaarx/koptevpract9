import java.util.Comparator;

public class MyVector {
    private MyNumber[] data;
    private int size;
    private int capacity;

    public MyVector() throws InvalidCapacityException {
        this(10);
    }

    public MyVector(int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than 0");
        }

        this.capacity = capacity;
        this.data = new MyNumber[capacity];
        this.size = 0;
    }

    public void add(MyNumber value) {
        if (value == null) {
            throw new NullValueException("Value cannot be null");
        }

        ensureCapacity();
        data[size] = value;
        size++;
    }

    public void addFirst(MyNumber value) {
        addAt(0, value);
    }

    public void addAt(int index, MyNumber value) {
        if (value == null) {
            throw new NullValueException("Value cannot be null");
        }

        if (index < 0 || index > size) {
            throw new InvalidIndexException("Invalid index: " + index);
        }

        ensureCapacity();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        size++;
    }

    public MyNumber get(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException("Invalid index: " + index);
        }

        return data[index];
    }

    public void clear() {
        data = new MyNumber[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    MyNumber temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public void sort(Comparator<MyNumber> comparator) {
        if (comparator == null) {
            throw new NullValueException("Comparator cannot be null");
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (comparator.compare(data[j], data[j + 1]) > 0) {
                    MyNumber temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    private void ensureCapacity() {
        if (size >= capacity) {

            if (capacity > Integer.MAX_VALUE / 2) {
                throw new VectorOverflowException("Vector is too large");
            }

            capacity *= 2;

            MyNumber[] newData = new MyNumber[capacity];

            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }
    }

    public void print() {
        System.out.print("[ ");

        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println("]");
    }
}
