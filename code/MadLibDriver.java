public class MadLibDriver {
    
    public static void main(String[] args) {
        WordList nouns = new WordList("nouns.txt");
        WordList verbs = new WordList("verbs.txt");
        WordList adjectives = new WordList("adjectives.txt");
        WordList adverbs = new WordList("adverbs.txt");
        
        String fileName = "psychology.txt";
        MadLib madLib = new MadLib(fileName);
        while (madLib.hasMoreBlanks()) {
            String type = madLib.getNextType();
            if (type == "noun") {
                String word = nouns.getRandomWord();
                madLib.fillNextBlank(word);
            } else if (type == "verb") {
                String word = verbs.getRandomWord();
                madLib.fillNextBlank(word);
            } else if (type == "adjectives") {
                String word = adjectives.getRandomWord();
                madLib.fillNextBlank(word);                
            } else {  // must be adverb
                String word = adverbs.getRandomWord();
                madLib.fillNextBlank(word);
            }
        }
    }
}
