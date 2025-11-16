import java.util.Set;

public class Game {
    private final String mySecretWord;
    private final Word word;
    private int guessesRemaining;
    private GameState gameState;
    public static final int MAX_GUESSES = 6;

    public Game(){
        this.mySecretWord = WordBank.generateRandomWord();
        this.word = new Word(mySecretWord);
        this.guessesRemaining = MAX_GUESSES;
        this.gameState = GameState.PLAYING;
    }

    public String getMySecretWord() {
        return mySecretWord;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int getGuessesRemaining() {
        return guessesRemaining;
    }

    public String getMaskedWord(){
        return word.getMaskedWord();
    }

    public Set<Character> getGuessedLetters(){
        return word.getGuessLetter();
    }

    public int getWordLength(){
        return word.getLength();
    }

    public boolean makeGuess(char letter) {

        boolean wasCorrect = word.guessLetter(letter);

        if (!wasCorrect) {
            this.guessesRemaining -= 1;
        }
        if (word.isFullyGuessed()) {
            this.gameState = GameState.WON;
        }
        else if (this.guessesRemaining <= 0) {
            this.gameState = GameState.LOST;
        }
        return wasCorrect;
    }
}
