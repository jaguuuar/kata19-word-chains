package com.kata.chain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.chain.repository.WordFileLoader;

import java.util.List;

@Service
public class FilterServiceImpl implements FilterService {

    private final WordFileLoader wordFileLoader;

    @Autowired
    public FilterServiceImpl(WordFileLoader wordFileLoader) {
        this.wordFileLoader = wordFileLoader;
    }

    @Override
    public List<String> getWords(int length) {
    	return wordFileLoader.loadWords(length);
    }

    @Override
    public List<String> getChildrenWord(String word, List<String> wordList) {
        return null;
    }
    
}