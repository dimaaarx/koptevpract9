public class Main {
    public static void main(String[] args) {
        try {
            MyVector vector = new MyVector(5);

            vector.add(new MyNumber(30));
            vector.add(new MyNumber(10));
            vector.add(new MyNumber(50));
            vector.add(new MyNumber(20));
            vector.add(new MyNumber(40));

            System.out.println("Original vector:");
            vector.print();

            vector.sort();
            System.out.println("Sorted with Comparable:");
            vector.print();

            vector.sort(new DescendingComparator());
            System.out.println("Sorted with Comparator:");
            vector.print();

        } catch (InvalidCapacityException e) {
            System.out.println("Capacity error: " + e.getMessage());

        } catch (InvalidIndexException e) {
            System.out.println("Index error: " + e.getMessage());

        } catch (NullValueException e) {
            System.out.println("Null value error: " + e.getMessage());

        } catch (VectorOverflowException e) {
            System.out.println("Overflow error: " + e.getMessage());
        }
    }
}
