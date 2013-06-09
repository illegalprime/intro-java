public class Wee {

    static void bar() throws Throwable {
        throw new Exception("Wee!");
    }

    static void foo() throws Throwable {
        bar();
        System.out.println("Foo!");
    }

    public static void main(String[] args) {
        try {        
            foo();
        } catch (Throwable t) {
            System.out.println(t.getMessage());
            //System.exit(1);
        }
        System.out.println("I'm still running.");
    }
}
