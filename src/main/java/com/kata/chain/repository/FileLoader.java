package com.kata.chain.repository;

import java.util.List;

public interface FileLoader {

	List<String> loadWords(int wordLength);
	
    List<String> loadWords(int wordLength, String filePath);
}
