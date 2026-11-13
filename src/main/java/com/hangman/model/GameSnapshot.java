
package com.hangman.model;

import java.util.Set;

public class GameSnapshot {

    private final String displayedWord;
    private final Set<Character> guessedLetters;
    private final int remainingAttempts;
    private final int maxAttempts;
    private final GameMode mode;
    private final boolean won;
    private final boolean lost;

    public GameSnapshot(
            String displayedWord,
            Set<Character> guessedLetters,
            int remainingAttempts,
            int maxAttempts,
            GameMode mode,
            boolean won,
            boolean lost) {

        this.displayedWord = displayedWord;
        this.guessedLetters = Set.copyOf(guessedLetters);
        this.remainingAttempts = remainingAttempts;
        this.maxAttempts = maxAttempts;
        this.mode = mode;
        this.won = won;
        this.lost = lost;
    }

    public String getDisplayedWord() {
        return displayedWord;
    }

    public Set<Character> getGuessedLetters() {
        return guessedLetters;
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

    public boolean isWon() {
        return won;
    }

    public boolean isLost() {
        return lost;
    }

    public boolean isFinished() {
        return won || lost;
    }
}
