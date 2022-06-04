package com.docker.backend.controller;

import com.docker.backend.entity.Lists;
import com.docker.backend.repository.ListsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ListsController {

    private final ListsRepository listsRepository;

    @GetMapping("/api/values")
    public ResponseEntity getLists() {
        List<Lists> findAll = listsRepository.findAll();
        return new ResponseEntity(findAll, HttpStatus.OK);
    }

    @PostMapping("/api/values")
    public ResponseEntity insertLists(@RequestBody Map<String, String> value) {
        listsRepository.save(new Lists(value.get("value")));

        return new ResponseEntity("성공", HttpStatus.OK);
    }
}
