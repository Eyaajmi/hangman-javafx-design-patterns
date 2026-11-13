
package com.hangman.composite;

import java.util.ArrayList;
import java.util.List;

import com.hangman.model.Word;

public class WordCategory implements CategoryComponent {

    private final String name;
    private final List<CategoryComponent> children;

    public WordCategory(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                "Category name cannot be empty."
            );
        }

        this.name = name.trim();
        this.children = new ArrayList<>();
    }

    public void add(CategoryComponent component) {

        if (component == null) {
            throw new IllegalArgumentException(
                "Component cannot be null."
            );
        }

        children.add(component);
    }

    public void remove(CategoryComponent component) {
        children.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Word> getWords() {

        List<Word> words = new ArrayList<>();

        for (CategoryComponent child : children) {
            words.addAll(child.getWords());
        }

        return List.copyOf(words);
    }
}
