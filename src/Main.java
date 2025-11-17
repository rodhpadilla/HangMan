import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hangman!");
        Scanner scanner = new Scanner(System.in);
        Game myGame = new Game();
        printInitialLetterCounting(myGame.getWordLength());
        while (myGame.getGameState() == GameState.PLAYING){
            printGuessedLeft(myGame.getGuessesRemaining());
            printMaskWord(myGame.getMaskedWord());
            printGuessedLetters(myGame.getGuessedLetters());
            char validLetter = getValidLetterInput(myGame.getGuessedLetters(), scanner);
            boolean wasCorrect = myGame.makeGuess(validLetter);
            System.out.println();
            if (!wasCorrect) {
                System.out.println("Incorrect!");
            } else {
                System.out.println("Correct!");
            }
            if (myGame.getGameState() != GameState.PLAYING){
                break;
            };
        }
        printWinCondition(myGame.getGameState(), myGame.getMySecretWord());
        scanner.close();

    }

    public static char getValidLetterInput(Set<Character> guessedLetters, Scanner scanner){
        while (true){
            System.out.println();
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.length() != 1) {
                System.out.println("Invalid input. Length incorrect. Try again");
                continue;
            }
            if (!input.matches("^[a-zA-Z]+$")) {
                System.out.println("Invalid input. Only letters are accepted. Try again");
                continue;
            }

            if (guessedLetters.contains(input.toLowerCase().charAt(0))){
                System.out.println("Invalid input. Letter is already guessed. Try another");
                continue;
            }

            return input.toLowerCase().charAt(0);
        }
    }

    public static void printInitialLetterCounting(int wordLength){
        System.out.println("The word has " + wordLength + " letters.");
    }

    public static void printGuessedLeft(int guessesRemaining){
        System.out.println("You have " + guessesRemaining + " guesses left.");
    }

    public static void printMaskWord(String maskedWord) {
        System.out.println("Word: " + maskedWord);
    }

    public static void printGuessedLetters(Set<Character> guessedLetters) {
        System.out.print("Guessed letters: ");
        int lengthLetters = guessedLetters.size();
        for (char letter : guessedLetters){
            if (lengthLetters != 1){
                System.out.print(letter + ", ");
                lengthLetters -= 1;
            } else {
                System.out.print(letter);
            }
        }
    }

    public static void printWinCondition(GameState state, String secretWord){
        switch (state){
            case WON -> System.out.println("Congratulations, you won");
            case LOST -> System.out.println("Sorry, You Lost!");
        }
        System.out.println("The word was: " + secretWord);
    }
}