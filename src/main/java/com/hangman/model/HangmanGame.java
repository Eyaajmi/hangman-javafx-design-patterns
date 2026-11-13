
package com.hangman.model;

import java.util.HashSet;
import java.util.Set;

public class HangmanGame {

    private final Word word;
    private final GameMode mode;
    private final Set<Character> guessedLetters;

    private final int maxAttempts;
    private int remainingAttempts;

    public HangmanGame(Word word, GameMode mode, int maxAttempts) {

        if (word == null) {
            throw new IllegalArgumentException("Word cannot be null.");
        }

        if (mode == null) {
            throw new IllegalArgumentException("Game mode cannot be null.");
        }

        if (maxAttempts <= 0) {
            throw new IllegalArgumentException(
                "Maximum attempts must be positive."
            );
        }

        this.word = word;
        this.mode = mode;
        this.maxAttempts = maxAttempts;
        this.remainingAttempts = maxAttempts;
        this.guessedLetters = new HashSet<>();
    }

    public boolean guessLetter(char letter) {

        if (isFinished()) {
            throw new IllegalStateException("The game is finished.");
        }

        char normalizedLetter = Character.toUpperCase(letter);

        if (!Character.isLetter(normalizedLetter)) {
            throw new IllegalArgumentException(
                "Please enter a valid letter."
            );
        }

        if (!guessedLetters.add(normalizedLetter)) {
            throw new IllegalArgumentException(
                "This letter has already been guessed."
            );
        }

        if (word.getText().indexOf(normalizedLetter) >= 0) {
            return true;
        }

        remainingAttempts--;
        return false;
    }

    public String getDisplayedWord() {

        StringBuilder displayedWord = new StringBuilder();

        for (char letter : word.getText().toCharArray()) {

            if (!Character.isLetter(letter)) {
                displayedWord.append(letter);
            } else if (guessedLetters.contains(letter)) {
                displayedWord.append(letter);
            } else {
                displayedWord.append('_');
            }

            displayedWord.append(' ');
        }

        return displayedWord.toString().trim();
    }

    public boolean isWon() {

        for (char letter : word.getText().toCharArray()) {

            if (Character.isLetter(letter)
                    && !guessedLetters.contains(letter)) {
                return false;
            }
        }

        return true;
    }

    public boolean isLost() {
        return remainingAttempts == 0 && !isWon();
    }

    public boolean isFinished() {
        return isWon() || isLost();
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public GameMode getMode() {
        return mode;
    }

    public Set<Character> getGuessedLetters() {
        return Set.copyOf(guessedLetters);
    }
    public GameSnapshot getSnapshot() {

    return new GameSnapshot(
        getDisplayedWord(),
        getGuessedLetters(),
        remainingAttempts,
        maxAttempts,
        mode,
        isWon(),
        isLost()
    );
}
}
