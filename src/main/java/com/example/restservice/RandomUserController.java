package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RandomUserController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RandomUserService randomUserService;

    @GetMapping(value = "/data")
    public Data getData() {
        return randomUserService.getAnyData();
    }

    @PostMapping(value = "/data/female")
    public Data getFemaleUserData(@RequestBody Gender gender) {
        return randomUserService.getFemaleUserData(gender.getGender());
    }

    @PostMapping(value= "data/female/Wexl")
    public Data getWexlFemaleUserData(@RequestBody Gender gender){
        return randomUserService.getWexlFemaleUserData(gender.getGender());
    }
}
