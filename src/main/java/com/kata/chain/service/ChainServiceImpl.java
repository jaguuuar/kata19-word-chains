package com.kata.chain.service;

import java.util.List;

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
        return null;
    }


}