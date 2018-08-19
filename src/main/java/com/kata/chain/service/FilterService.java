package com.kata.chain.service;

import java.util.List;

public interface FilterService {

    List<String> getWords(int length);

    List<String> getChildrenWord(String word, List<String> wordList);
}