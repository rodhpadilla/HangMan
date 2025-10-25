# Hangman

The goal of this project is to create a console-based Hangman game. The program will pick a secret word, and the user will try to guess it, one letter at a time. This project is a major step up in Object-Oriented Programming (OOP) and will introduce you to the Java Collections Framework.

It will focus on:
1.  **Encapsulation:** Using `public` and `private` access specifiers to protect data.
2.  **Classes and Objects:** Designing a system with multiple interacting objects.
3.  **Keywords:** Using `static` for utility methods and `final` for constants.
4.  **Java Collections:** Using `List`/`ArrayList` for a word bank and `Set`/`HashSet` to store guesses.
5.  **Enums:** Solidifying the concept by managing the game's state.

---

## Design

We will build this program using four classes and one enum. This separation of concerns is the core of OOP.

### Basic Classes & Enums Overview

* **`Main` (Class):** The entry point. Responsible for running the main game loop, getting user input, and printing to the console.
* **`WordBank` (Class):** A utility class. It won't be instantiated. It will use `static` methods and fields to store a `List` of all possible words and provide a random one.
* **`Word` (Class):** A core data class. It will be responsible for holding the `private final` secret word and the `private Set` of guessed letters. This class is where **Encapsulation** is key.
* **`Game` (Class):** The main "engine." This class will manage the game's *state*. It will hold the `Word` object, the number of guesses remaining, and the current `GameState`.
* **`GameState` (Enum):** To represent the current state of the game: `PLAYING`, `WON`, or `LOST`.

---

## Skeleton

Your task is to define the necessary methods, fields, and connections between these components.

```java
import java.util.Scanner;
import java.util.List;
import java.util.Set;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // Your application logic starts here.
        // How will you create and run the game?
    }
}

// TODO: Define an Enum called GameState
// What are the possible states a game can be in?

class WordBank {
    // TODO: How will this class store a list of words?
    // How will it provide a random word to the rest of the program?
    // Should it have a constructor? Or should its methods be static?
}

class Word {
    // TODO: What data does this class need to hold?
    // Remember Encapsulation: what should be private?
    // What public methods will other classes (like Game) need to
    // interact with this Word?
    // How will it know what the "masked word" (e.g., "_ A _ A") is?
}

class Game {
    // TODO: What data does this class need to manage the game's state?
    // (e.g., guesses left, the word being played, etc.)
    // How will it be initialized?
    // What is the main method that will update the game
    // every time a user makes a guess?
    // How will it check for a win or loss condition?
}
```

---

## Expected Output

The user will interact by typing one letter at a time. The program will redisplay the game state after each guess.

```
Welcome to Hangman!
The word has 4 letters.
You have 6 guesses left.
Word: _ _ _ _
Guessed letters:
> a

Correct!
You have 6 guesses left.
Word: _ A _ A
Guessed letters: a
> e

Incorrect!
You have 5 guesses left.
Word: _ A _ A
Guessed letters: a, e
> j

Correct!
You have 5 guesses left.
Word: J A _ A
Guessed letters: a, e, j
> v

Correct!
Congratulations, you won!
The word was: JAVA
```

---

## More Details

### `Main` class
* This class should only handle user I/O (printing and scanning).
* How will you get a single, valid letter from the user?
* How will you handle it if they enter a non-letter, or a letter they've already guessed?
* What is the main loop condition? (Hint: `GameState`).

### `WordBank` class
* What is the best `Collection` type to store a list of words?
* How can you use `static` and `final` here for your word list and methods?
* How do you generate a random number to pick from this list?

### `Word` class
* This is your "data shield." Its fields must be `private`.
* What `Collection` type is best for storing *guessed letters* so you don't have to worry about duplicates?
* What's the logic for building the "masked word" string? You'll need to loop through the secret word and check against your guessed letters.
* What should the `guessLetter` method return to the `Game` class to let it know if the guess was correct or not?

### `Game` class
* This class is the "engine" that connects all the other parts.
* How will it get a new `Word` object when it starts?
* What should happen every time a user makes a guess?
    1.  The `Game` class needs to tell the `Word` class about the guess.
    2.  Did the `Word` class report a correct or incorrect guess?
    3.  Based on that, should `remainingGuesses` change?
    4.  After the guess, how do you check for a win condition?
    5.  How do you check for a loss condition?
    6.  How will you update the `gameState` field based on this?

---

## Putting It All Together

1.  **Start with the `WordBank` and `Word` classes.** These are your data layer. Write them first.
2.  **Define the `GameState` enum.**
3.  **Build the `Game` class.** This is the trickiest part. Wire it up to the `Word` class.
4.  **Build the `Main` class last.** This is just the user-interface.

This structure forces you to think about how objects talk to each other and protects your data. Good luck!