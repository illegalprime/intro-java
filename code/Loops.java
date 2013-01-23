import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("Enter a string of alphanumeric characters (exit to quit):");
            String input = kbd.next();
            int digitCount = 0, letterCount = 0;
            for (int i = 0; i < input.length(); ++i) {
                char c = input.charAt(i);
                Character ch = new Character(c);
                if (ch.isDigit(c)) digitCount++;
                if (Character.isAlphabetic(c)) letterCount++;
            }
            System.out.printf("Your input contained %d digits and %d letters.%n",
                              digitCount, letterCount);
            keepGoing = (input.equalsIgnoreCase("exit")) ? false : true;
        }

        for (int i = 0; i < 10; ++i)
            System.out.println("Meow!");

        String mystery = "mnerigpaba";
        String solved = "";
        int len = mystery.length();
        for (int i = 0, j = len - 1; i < len/2; ++i, --j) {
            solved = solved + mystery.charAt(i) + mystery.charAt(j);
        }
        System.out.println(solved);
   }
}