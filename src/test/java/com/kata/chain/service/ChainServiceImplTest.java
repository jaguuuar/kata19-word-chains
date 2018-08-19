package com.kata.chain.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kata.chain.repository.WordFileLoader;


class ChainServiceImplTest {

	private WordFileLoader fileLoader = new WordFileLoader();
	private FilterServiceImpl filter = new FilterServiceImpl(fileLoader); 
	private ChainServiceImpl chain = new ChainServiceImpl(filter); 
	

	@Test
	void testFindChain_PathExist_CAT_DOG() {
		List<String> expected = Arrays.asList("cat", "cot", "cog", "dog");
		List<String> actual = chain.findChain("cat", "dog");
		
		assertThat(actual, is(expected));
	}
	
	@Test
	void testFindChain_PathExist_LEAD_GOLD() {
		List<String> expected = Arrays.asList("lead", "load", "goad", "gold");
		List<String> actual = chain.findChain("lead", "gold");
		
		assertThat(actual, is(expected));
	}
		
	@Test
	void testFindChain_PathNotExist() {
		List<String> expected = new ArrayList<>();
		List<String> actual = chain.findChain("Übermenschen", "zootomically");
		
		assertThat(actual, is(expected));
	}
	
	@Test
	void testFindChain_SingleLetter() {
		List<String> expected = Arrays.asList("a", "i");
		List<String> actual = chain.findChain("a", "i");
		
		assertThat(actual, is(expected));
	}
	
	@Test
	void testFindChain_Empty() {
		List<String> expected = new ArrayList<>();
		List<String> actual = chain.findChain("", "");
		
		assertThat(actual, is(expected));
	}
	
	@Test
	void testFindChain_DiffLength() {
		List<String> expected = new ArrayList<>();
		List<String> actual = chain.findChain("cat", "horse");
		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void testFindChain_Performance() {
		Assertions.assertTimeout(Duration.ofMillis(1000), () -> {
			chain.findChain("lead", "gold");
		});
	}
}
