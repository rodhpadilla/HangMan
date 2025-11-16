import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Word {
    private final String secretWord;
    private final Set<Character> guessLetterSet;

    Word(String secretWord) {
        this.secretWord = secretWord;
        this.guessLetterSet = new HashSet<>();
    }

    public Set<Character> getGuessLetter() {
        return guessLetterSet;
    }

    public int getLength(){
        return secretWord.length();
    }

    public boolean guessLetter(char letter) {
        this.guessLetterSet.add(letter);
        for (char secretWordLetter : secretWord.toCharArray()){
            if (letter == secretWordLetter) {
                return true;
            }
        }
        return false;
    }

    public String getMaskedWord(){
        ArrayList<String> maskedWordList = new ArrayList<>();
        for (char secretWordLetter : secretWord.toCharArray()){
            if (guessLetterSet.contains(secretWordLetter)){
                maskedWordList.add(String.valueOf(secretWordLetter));
            } else {
                maskedWordList.add("_");
            }
        }
        return String.join(" ", maskedWordList);
    }

    public boolean isFullyGuessed(){
        for (char secretWordLetter : secretWord.toCharArray()){
            if (!guessLetterSet.contains(secretWordLetter)){
                return false;
            }
        }
        return true;
    }

}
