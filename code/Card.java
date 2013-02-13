import java.util.Arrays;

public class Card {

    public static final String[] VALID_RANKS =
    {"2", "3", "4", "5", "6", "7", "8", "9",
     "10", "jack", "queen", "king", "ace"};
    public static final String[] VALID_SUITS =
    {"diamonds", "clubs", "hearts","spades"};

    private String rank;
    private String suit;

    public Card(String aCardDescription) {
        this(extractRank(aCardDescription), extractSuit(aCardDescription));
    }

    public Card(String aRank, String aSuit) {
        String theRank = normalizeString(aRank);
        String theSuit = normalizeString(aSuit);
        if (isValidRank(theRank)) {
            rank = theRank;
        } else {
            String msg = "Illegal rank: " + theRank;
            throw new IllegalArgumentException(msg);
        }
        if (isValidSuit(theSuit)) {
            suit = theSuit;
        } else {
            String msg = "Illegal suit: " + theSuit;
            throw new IllegalArgumentException(msg);
        }
    }

    public String toString() {
        return rank + " of " + suit;
    }
    
    private static String extractRank(String cardDescription) {
        String[] parts = cardDescription.split(" ");
        if (parts.length != 3) {
            String msg="Illegal card description: " + cardDescription;
            msg += "\nCard descriptions must have the form <rank> of <suit>";
            msg += ", as in \"ace of spades\".";
            throw new IllegalArgumentException(msg);
        }
        return parts[0];
    }

    private static String extractSuit(String cardDescription) {
        String[] parts = cardDescription.split(" ");
        if (parts.length != 3) {
            String msg="Illegal card description: " + cardDescription;
            msg += "\nCard descriptions must have the form <rank> of <suit>";
            msg += ", as in \"ace of spades\".";
            throw new IllegalArgumentException(msg);
        }
        return parts[2];
    }

    private static String normalizeString(String someString) {
        return someString.trim().toLowerCase();
    }

    private static boolean isValidRank(String someRank) {
        return Arrays.asList(VALID_RANKS).contains(someRank);
    }

    private static boolean isValidSuit(String someSuit) {
        return Arrays.asList(VALID_SUITS).contains(someSuit);
    }

    public static void main(String[] args) {
        Card c1 = new Card("2 of diamonds");
        System.out.println(c1);
        Card c2 = new Card("queen of hearts");
        System.out.println(c2);
        // Card c3 = new Card("king of prussia");
        // System.out.println(c3);
        Card c4 = new Card("1 diamonds");
        System.out.println("Oops.  IllegalArgumentException wasn't thrown.");

    }
}
