package com.project.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
public class RandomUserController {

    private RestTemplate restTemplate;

    @Autowired
    RandomUserService randomUserService;

    //fetches random data from the api
    @GetMapping(value = "/data")
    public Data getData() {
        return randomUserService.getAnyData();
    }

    //fetches only female user data using the random api when gender is passed as request body
    @PostMapping(value = "/data/female")
    public Data getFemaleUserData(@RequestBody Gender gender) {
        return randomUserService.getFemaleUserData(gender.getGender());
    }

    //fetches and updates the first name and last name of female user data when gender is passed as req body
    @PostMapping(value= "data/female/Wexl")
    public Data getWexlFemaleUserData(@RequestBody Gender gender){
        return randomUserService.getWexlFemaleUserData(gender.getGender());
    }
}
