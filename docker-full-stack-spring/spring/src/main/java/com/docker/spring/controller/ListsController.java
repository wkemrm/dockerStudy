package com.docker.spring.controller;

import com.docker.spring.entity.Lists;
import com.docker.spring.repository.ListsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        Map<String, String> response = new HashMap();
        response.put("success", "true");
        response.put("value", value.get("value"));
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
