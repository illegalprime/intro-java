public class PartialIntArray {

    private int[] elementData;
    private int size;

    public PartialIntArray(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        this.elementData = new int[initialCapacity];
    }

    public ArrayList() {
        this(10);
    }

    public void add(int e) {
        elementData[size++] = e;
    }

    public int get(int index) {
        return elementData(index);
    }

    public int size() {
        return this.size;
    }


}
