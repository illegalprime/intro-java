public class Foo {

    private String bar;

    public Foo(Sting bar) {
        this.bar = bar;
    }

    public boolean equals(Object other) {
        return this.bar.equals(other.bar);
    }

    public static void main(String[] args) {
        Foo foo1 = new Foo("bar");
        Foo foo2 = new Foo("bar");
        Foo foo3 = f1;
        System.out.println("foo1.equals(f002): " + foo1.equals(foo2));
        System.out.println("foo1 == foo2: " + foo1 == foo2);
        System.out.println("foo1 == foo3: " + foo1 == foo3);
    }
}
