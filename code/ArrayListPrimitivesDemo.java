import java.util.ArrayList;

public class ArrayListPrimitivesDemo {

    public static void main(String[] args) {
        ArrayList ints = new ArrayList();
        ints.add(new Integer(42));
        ints.add(new Integer(66));
        // With an untyped collection, Java will auto-box when adding
        ints.add(99);
        System.out.println(ints);

        // However, autoboxing doesn't happen when retrieving 
        // from an untyped collection
        // int num = ints.get(0); // won't compile

        // So the old-style way is to cast it to wrapper type, then unboxing
        // is done on the casted wrapper object
        int num = (Integer) ints.get(0);
    }

}
