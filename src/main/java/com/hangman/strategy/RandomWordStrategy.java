
package com.hangman.strategy;

import java.util.List;
import java.util.Random;

import com.hangman.model.Word;

public class RandomWordStrategy implements WordSelectionStrategy {

    private final Random random = new Random();

    @Override
    public Word selectWord(List<Word> words) {

        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException(
                "The word list cannot be empty."
            );
        }

        int randomIndex = random.nextInt(words.size());

        return words.get(randomIndex);
    }
}
