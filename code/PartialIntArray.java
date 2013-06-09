public class PartialIntArray {

    private int[] elementData;
    private int size;

    public PartialIntArray(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        this.elementData = new int[initialCapacity];
    }

    public PartialIntArray() {
        this(10);
    }

    public void add(int e) {
        elementData[size++] = e;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            // ...
        }
        return elementData[index];
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        PartialIntArray pia = new PartialIntArray();
        pia.add(2);
        pia.add(4);
        pia.add(6);
        for (int i = 0; i < pia.size(); i++) {
            System.out.println(pia.get(i));
        }
        pia.get(10);
    }

}
