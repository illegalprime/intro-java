public class ExamTestCode {

    static class Kitten {
        
        private String name;

        public Kitten(String name) {
            name = name;
        }

        public String toString() {
            return "Kitten: " + name;
        }

        public boolean equals(Kitten other) {
            return this.name.equals(other.name);
        }
    }

    static boolean test() {
        return "Foo".equals("foo");
    }

    public static void main(String[] args) {
        System.out.println(new Double(1) / 2);
        System.out.println(true && "Foo".equals("foo"));
        System.out.println("Kitten stuff:");
        Object maggie = new Kitten("Maggie");
        Object fiona = new Kitten("Fiona");
        Kitten fiona2 = new Kitten("Fiona");
        System.out.println(maggie.toString());
        System.out.println(fiona == fiona2);
        Kitten[] kittens = new Kitten[5];
    }
}
