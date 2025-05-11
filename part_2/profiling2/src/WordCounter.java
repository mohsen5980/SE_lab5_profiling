import java.util.*;

public class WordCounter {

    public static void main(String[] args) {
        String longText = generateLongText(10000);
        Map<String, Integer> wordCounts = countWords(longText);

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // متن ساختگی تولید می‌کند
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

    // نسخه غیربهینه شمارش کلمات
    public static Map<String, Integer> countWords(String text) {
        List<String> words = new ArrayList<>();
        String[] splitWords = text.toLowerCase().split("\\W+");

        for (String word : splitWords) {
            words.add(word);
        }

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            int count = 0;
            for (String w : words) {
                if (w.equals(word)) count++;
            }
            wordMap.put(word, count);
        }

        return wordMap;
    }
}
