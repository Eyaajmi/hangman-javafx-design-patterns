
package com.hangman.strategy;

import java.util.List;
import com.hangman.model.Word;

public interface WordSelectionStrategy {

    Word selectWord(List<Word> words);
}
