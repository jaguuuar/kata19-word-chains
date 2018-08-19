package com.kata.chain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.chain.repository.FileLoader;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterServiceImpl implements FilterService {

    private final FileLoader fileLoader;

    @Autowired
    public FilterServiceImpl(FileLoader fileLoader) {
        this.fileLoader = fileLoader;
    }

    @Override
    public List<String> getWords(int length) {
    	return fileLoader.loadWords(length);
    }

    @Override
    public List<String> getChildrenWord(String word, List<String> wordList) {
        List<String> childrenWord = new ArrayList<>();

        wordList.stream()
                .filter(currentWord -> checkDiff(word, currentWord))
                .forEach(childrenWord::add);

        return childrenWord;
    }

    private boolean checkDiff(String word1, String word2) {
        int diff = 0;
        for (int n = 0; n < word1.length(); n++) {
            if (word1.charAt(n) != word2.charAt(n)) {
                diff++;
                if(diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}