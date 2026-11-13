
package com.hangman.strategy;

import java.util.List;
import java.util.Random;

import com.hangman.model.Word;

public class DifficultyWordStrategy implements WordSelectionStrategy {

    private final Random random = new Random();

    private final int difficultyLevel;

    public DifficultyWordStrategy(int difficultyLevel) {

        if (difficultyLevel < 1 || difficultyLevel > 3) {
            throw new IllegalArgumentException(
                "Difficulty must be between 1 and 3."
            );
        }

        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Word selectWord(List<Word> words) {

        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException(
                "The word list cannot be empty."
            );
        }

        List<Word> filteredWords = words.stream()
                .filter(word ->
                    word.getDifficultyLevel() == difficultyLevel)
                .toList();

        if (filteredWords.isEmpty()) {
            throw new IllegalArgumentException(
                "No words available for this difficulty level."
            );
        }

        int randomIndex = random.nextInt(filteredWords.size());

        return filteredWords.get(randomIndex);
    }
}
