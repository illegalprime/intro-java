public class ArrayBasics {
    
    class Dog {
        public void speak() {
            System.out.println("Woof, woof!");
        }
    }

    public static void main(String[] args) {
        double[] scores = new double[5];
        System.out.println("After double[] scores = new double[5]:");
        for (int i = 0; i < 5; ++i) {
            System.out.printf("scores[%d] = %.2f%n", i, scores[i]);
        }

        scores[0] = 89;
        scores[1] = 100;
        scores[2] = 95.6;
        scores[3] = 84.5;
        scores[4] = 91;
        scores[scores.length - 1] = 99.2;
        System.out.println("After element-by-element initialization:");
        for (int i = 0; i < 5; ++i) {
            System.out.printf("scores[%d] = %.2f%n", i, scores[i]);
        }
        System.out.println("Trying scores[scores.length] = 100 causes:");
        // And this line will cause an error at run-time:
        scores[scores.length] = 100;

    }
}
