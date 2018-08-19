package com.kata.chain.repository;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class WordFileLoader implements FileLoader {

    private static final String DEFAULT_FILE_PATH = "src/main/resources/wordlist.txt";

    @Override
    public List<String> loadWords(int wordLength, String filePath) {
        String absolutePath = new File(filePath).getAbsolutePath();
        List<String> wordList = new ArrayList<>();
        String word;

        try (Scanner scanner = new Scanner(new File(absolutePath))) {
            while (scanner.hasNextLine()) {
                word = scanner.nextLine();
                if (word.length() == wordLength) {
                    wordList.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wordList;
    }

    @Override
    public List<String> loadWords(int wordLength) {
        return this.loadWords(wordLength, DEFAULT_FILE_PATH);
    }
}
