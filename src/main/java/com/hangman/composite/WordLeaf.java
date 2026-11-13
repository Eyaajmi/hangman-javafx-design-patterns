
package com.hangman.composite;

import java.util.List;
import com.hangman.model.Word;

public class WordLeaf implements CategoryComponent {

    private final Word word;

    public WordLeaf(Word word) {
        if (word == null) {
            throw new IllegalArgumentException(
                "Word cannot be null."
            );
        }

        this.word = word;
    }

    @Override
    public String getName() {
        return word.getText();
    }

    @Override
    public List<Word> getWords() {
        return List.of(word);
    }
}
