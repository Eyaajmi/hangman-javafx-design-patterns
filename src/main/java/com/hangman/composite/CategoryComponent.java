
package com.hangman.composite;

import java.util.List;
import com.hangman.model.Word;

public interface CategoryComponent {

    String getName();

    List<Word> getWords();
}
