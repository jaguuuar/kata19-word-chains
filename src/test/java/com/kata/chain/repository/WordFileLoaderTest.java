package com.kata.chain.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class WordFileLoaderTest {
	
	WordFileLoader fileReader = new WordFileLoader();

	@Test
	void testLoadWords_WordLength_6() {
		List<String> expected = Arrays.asList("abide", "acorn", "affix", "afoot", "agent", "agile", "aging", "agony");
		List<String> actual = fileReader.loadWords(5, "src/main/resources/wordlistTest.txt");
		
		assertThat(actual, is(expected));
	}
	
	@Test
	void testLoadWords_WordLength_0() {
		List<String> expected = new ArrayList<>();
		List<String> actual = fileReader.loadWords(0, "src/main/resources/wordlistTest.txt");
		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void testLoadWords_WrongFilePath() {
		List<String> expected = new ArrayList<>();
		List<String> actual = fileReader.loadWords(0, "src/main/resources/WRONG_PATH");

		assertThat(actual, is(expected));
	}
	
}
