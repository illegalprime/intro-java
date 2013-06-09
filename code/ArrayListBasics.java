import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListBasics {

    public static void main(String[] args) {
        ArrayList tasks = new ArrayList();
        tasks.add("Eat");
        tasks.add("Sleep");
        tasks.add("Code");

        System.out.println("Life of a CS major:");

        // Best way to iterate: using for-each loop
        for (Object task: tasks) {
            System.out.println(task);
        }

        System.out.println("\nLet's be real:");
        tasks.remove("Sleep");

        // Another way to iterate, using iterator and while
        Iterator tasksIter = tasks.iterator();
        while (tasksIter.hasNext()) {
            Object task = tasksIter.next();
            System.out.println(task);
        }

        System.out.println("\nOK, maybe:");
        tasks.add("Red Bull");
        
        // Using iterator and for (notice we're incrementing the 
        // iterator in the body, not the for-loop header).
        for (Iterator iter = tasks.iterator(); iter.hasNext(); ) {
            Object task = iter.next();
            System.out.println(task);
        }

        System.out.println("\nPerhaps in a different order:");
        tasks.remove("Code");
        tasks.add("Code");

        // Using indexes and for:
        for (int i = 0; i < tasks.size(); i++) {
            Object task = tasks.get(i);
            System.out.println(task);
        }
        System.out.println("\nNah, we need sleep!");
        tasks.add(1, "Sleep");
        for (int i = 0; i < tasks.size(); i++) {
            Object task = tasks.get(i);
            System.out.println(task);
        }

        // System.out.println("\nOr let the computer sort it out:");
        // Collections.sort(tasks);
        // for (Object task: tasks) {
        //     System.out.println(task);
        // }
    }

}
