package com.kata.chain.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kata.chain.repository.WordFileLoader;


class FilterServiceImplTest  {
		
	private WordFileLoader wordFileLoader = new WordFileLoader();
	private FilterServiceImpl filter = new FilterServiceImpl(wordFileLoader);
	
	private List<String> words = wordFileLoader.loadWords(4, "src/main/resources/wordlistTest2.txt");
	
	@Test
	void testGetChildrenWord_Positive() {
		List<String> expected = Arrays.asList("abaa", "aaca", "aaad");
		List<String> actual = filter.getChildrenWord("aaaa", words);
		
		assertThat(actual, is(expected));
	}
	
	@Test
	void testGetChildrenWord_NoMatch() {
		List<String> expected = new ArrayList<>();
		List<String> actual = filter.getChildrenWord("cdbc", words);
		
		assertThat(actual, is(expected));
	}
	
	@Test
	void testGetChildrenWord_NoWordInFile() {
		List<String> expected = new ArrayList<>();
		List<String> actual = filter.getChildrenWord("xxxx", words);
		
		assertThat(actual, is(expected));
	}
		

}