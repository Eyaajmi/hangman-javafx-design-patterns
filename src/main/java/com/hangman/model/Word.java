
package com.hangman.model;

import java.util.Locale;

public class Word {

    private final String text;
    private final String hint;
    private final int difficultyLevel;

    public Word(String text, String hint, int difficultyLevel) {

        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(
                "The word cannot be empty."
            );
        }

        if (hint == null || hint.isBlank()) {
            throw new IllegalArgumentException(
                "The hint cannot be empty."
            );
        }

        if (difficultyLevel < 1 || difficultyLevel > 3) {
            throw new IllegalArgumentException(
                "Difficulty must be between 1 and 3."
            );
        }

        this.text = text.trim().toUpperCase(Locale.ROOT);
        this.hint = hint.trim();
        this.difficultyLevel = difficultyLevel;
    }

    public String getText() {
        return text;
    }

    public String getHint() {
        return hint;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

}
