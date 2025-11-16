import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordBank {
    private static final ArrayList<String> wordList = new ArrayList<>(
            List.of(
                "pelucho",
                "negrita",
                "bigotes",
                "pepe",
                "felix")
    );

    public static String generateRandomWord() {
        Random random = new Random();
        int magicNumber = random.nextInt(wordList.size());
        return wordList.get(magicNumber);
    }
}
