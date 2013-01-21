/**
 * NameParser takes a single String-valued command line argument of
 * the form "last_name, first_name" and prints the first and last names
 * separately.
 */
public class NameParser {

    public static void main(String[] args) {
	String name = args[0];
	int commaPos = name.indexOf(",");
	int len = name.length();
	String lastName = name.substring(0, commaPos).trim();
	String firstName = name.substring(commaPos + 1, len).trim();
	System.out.println("First name:\t" + firstName);
	System.out.println("Last name:\t" + lastName);
    }
    
}