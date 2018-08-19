package com.kata.chain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChainServiceImpl implements ChainService {

    private final FilterService filterService;

    @Autowired
    public ChainServiceImpl(FilterService filterService) {
        this.filterService = filterService;
    }

    @Override
    public List<String> findChain(String startWord, String endWord) {
    	List<String> chain = new ArrayList<>();
    	if(startWord.length() != endWord.length()) {
    		return chain;
    	}
    	
        Map<String, String> wordTree = getWordTree(startWord, endWord);
        if (!wordTree.containsKey(endWord)) {
            return chain;
        }

        String word = endWord;
        while (!word.equals(startWord)) {
            chain.add(0, word);
            word = wordTree.get(word);
        }
        chain.add(0, startWord);

        return chain;
    }

    private Map<String, String> getWordTree(String startWord, String endWord) {
        Map<String, String> wordTree = new HashMap<>();
        List<String> worldList = filterService.getWords(startWord.length());
        Queue<String> wordQueue = new LinkedList<>();
        wordQueue.add(startWord);

        String parentWord = "";
        while (!wordQueue.isEmpty() && !parentWord.equals(endWord)) {
            parentWord = wordQueue.remove();
            List<String> childrenWord = filterService.getChildrenWord(parentWord, worldList);
            for (String child : childrenWord) {
                if (!wordTree.containsKey(child)) {
                    wordTree.put(child, parentWord);
                    wordQueue.add(child);
                }
            }
        }

        return wordTree;
    }
}