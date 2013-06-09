public class Bugs {

    /**
     * A helper method that sends an email message.
     */
    private static void sendEmail(String body, String recipient) {
        // Pretend we have code that sends email here.
    }


    /**
     * A helper method to check for the presense of the @ symbol in a String
     *
     * @param s a String
     * @return true if s contains @, false otherwise
     */
    private static boolean containsAtSymbol(String s) {
        boolean containsAt = false;
        // Can you spot the bugs here before we run the program?
        for (int i = 0; i <= s.length(); i++) {
            if (s.substring(i, i) == "@") containsAt = true;
            // What if @ is early in the string?
        }
        return containsAt;
    }

    private static String arrayToString(String[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length - 1; ++i) {
            sb.append(array[i] + ", ");
        }
        sb.append(array[array.length - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {

        // If no command line arguments, what is args.length?
        String email = null;
        if (args.length > 0) {
            email = args[0];
        } else {
            System.out.println("Please suppply an email address as "
                               + "a command line argument.");
            System.exit(0);
        }
        
        // What if email not assigned a value after initialization?
        int len = email.length();
        
        // What if email, an aribitrary String, is not a valid email address?
        sendEmail("Hi!", email);
    }
}
