import java.util.*;

public class ParagraphAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a paragraph:");
        String paragraph = scanner.nextLine().toLowerCase(); // Convert to lowercase for consistency

        // Counting words
        String[] words = paragraph.split("\\s+");
        int wordCount = words.length;

        // Counting letters
        int letterCount = 0;
        for (String word : words) {
            letterCount += word.replaceAll("[^a-zA-Z]", "").length();
        }

        // Counting letter frequency
        Map<Character, Integer> letterFrequency = new HashMap<>();
        for (char letter : paragraph.replaceAll("[^a-zA-Z]", "").toCharArray()) {
            letterFrequency.put(letter, letterFrequency.getOrDefault(letter, 0) + 1);
        }

        // Finding maximum repeating letter
        char maxRepeatingLetter = ' ';
        int maxRepeatingCount = 0;
        for (Map.Entry<Character, Integer> entry : letterFrequency.entrySet()) {
            if (entry.getValue() > maxRepeatingCount) {
                maxRepeatingLetter = entry.getKey();
                maxRepeatingCount = entry.getValue();
            }
        }

        // Counting word frequency
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        // Finding most frequent words
        List<String> mostFrequentWords = new ArrayList<>();
        int maxWordFrequency = 0;
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() > maxWordFrequency) {
                mostFrequentWords.clear();
                mostFrequentWords.add(entry.getKey());
                maxWordFrequency = entry.getValue();
            } else if (entry.getValue() == maxWordFrequency) {
                mostFrequentWords.add(entry.getKey());
            }
        }

        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of letters: " + letterCount);
        System.out.println("Maximum repeating letter: " + maxRepeatingLetter + " (Count: " + maxRepeatingCount + ")");
        System.out.println("Most frequent words: " + mostFrequentWords);

        scanner.close();
    }
}
