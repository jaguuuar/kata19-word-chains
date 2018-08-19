package com.kata.chain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kata.chain.service.ChainService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChainController {

    private final ChainService chainService;

    @Autowired
    public ChainController(ChainService chainService) {
        this.chainService = chainService;
    }

    @GetMapping(value = "/chain", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getChain(
            @RequestParam String startWord,
            @RequestParam String endWord
    ) {
        List<String> chain = chainService.findChain(startWord, endWord);

        return chain != null && !chain.isEmpty() ?
                new ResponseEntity<>(chain, HttpStatus.OK) :
                new ResponseEntity<>(chain, HttpStatus.NO_CONTENT);
    }
}
