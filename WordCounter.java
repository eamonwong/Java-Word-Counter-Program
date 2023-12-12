import java.util.HashMap;
import java.util.Map;

// Translator class definition
class Translator {
    public String translate(String word) {
        // Assume this method returns the English name for the given word
        return word;
    }
}

// WordCounter class definition
public class WordCounter {
    private Map<String, Integer> wordCountMap;
    private Translator translator;

    public WordCounter(Translator translator) {
        this.wordCountMap = new HashMap<>();
        this.translator = translator;
    }

    // Method to add one or more words to the word counter
    public void addWords(String... words) {
        for (String word : words) {
            // Check if the word contains only alphabetic characters
            if (word.matches("[a-zA-Z]+")) {
                // Translate the word to English using the provided Translator class
                String englishWord = translator.translate(word.toLowerCase());

                // Update the word count in the map
                wordCountMap.put(englishWord, wordCountMap.getOrDefault(englishWord, 0) + 1);
            } else {
                System.out.println("Error: Non-alphabetic characters not allowed for word: " + word);
            }
        }
    }

    // Method to get the count of a given word
    public int getCount(String word) {
        // Translate the input word to English
        String englishWord = translator.translate(word.toLowerCase());

        // Get the count from the map or return 0 if the word is not present
        return wordCountMap.getOrDefault(englishWord, 0);
    }

    public static void main(String[] args) {
        // Example usage
        Translator translator = new Translator(); // Assume Translator class is provided
        WordCounter wordCounter = new WordCounter(translator);

        // Adding words to the counter
        wordCounter.addWords("flower", "flor", "blume");
        wordCounter.addWords("flower", "rose", "blume");

        // Getting the count of a word
        System.out.println("Count of 'flower': " + wordCounter.getCount("flower")); // Output: 3
        System.out.println("Count of 'rose': " + wordCounter.getCount("rose"));     // Output: 1
        System.out.println("Count of 'nonAlpha123': " + wordCounter.getCount("nonAlpha123")); // Output: Error message
    }
}
