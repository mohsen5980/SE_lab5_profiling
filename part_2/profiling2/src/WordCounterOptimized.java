import java.util.*;

public class WordCounterOptimized {

    public static void main(String[] args) {
        String longText = generateLongText(10000);
        Map<String, Integer> wordCounts = countWords(longText);

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static String generateLongText(int wordCount) {
        String[] sampleWords = {"java", "memory", "cpu", "thread", "object", "class", "method"};
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < wordCount; i++) {
            sb.append(sampleWords[rand.nextInt(sampleWords.length)]);
            sb.append(" ");
        }

        return sb.toString();
    }

    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordMap = new HashMap<>();
        String[] splitWords = text.toLowerCase().split("\\W+");

        for (String word : splitWords) {
            if (!word.isEmpty()) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordMap;
    }
}
