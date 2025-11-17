import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordBank {
    private static final ArrayList<String> wordList = new ArrayList<>();

    static {
        populateList();
    }

    private static void populateList(){
        try (Scanner wordsFile = new Scanner(new File("src/words.txt"))){
            while (wordsFile.hasNext()){
                String word = wordsFile.nextLine().toLowerCase();
                if (!word.isEmpty()){
                    wordList.add(word);
                }
            }
        }
        catch (FileNotFoundException ex) {
            throw new RuntimeException("FATAL: Could not find the word bank file at src/words.txt", ex);
        }
    }

    public static String generateRandomWord() {
        Random random = new Random();
        int magicNumber = random.nextInt(wordList.size());
        return wordList.get(magicNumber);
    }
}
