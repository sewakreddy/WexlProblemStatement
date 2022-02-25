package com.project.dto;

import com.project.model.AddressRepository;
import com.project.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RandomUserService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    public RandomUserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Data getAnyData(){
        ResponseEntity<Data> response = restTemplate.exchange(
                "https://randomuser.me/api/?format=json",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Data>() {
                });

        Data responseData = response.getBody();

        userRepository.save(responseData.toUserEntity());
        addressRepository.save(responseData.toAddressEntity());

        return responseData;
    }

    public Data getFemaleUserData(String string){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Map<String, String> params = new HashMap<>();
        params.put("gender", string);
        params.put("format", "json");

        String urlTemplate = UriComponentsBuilder.fromHttpUrl("https://randomuser.me/api/")
                .queryParam("format", "json")
                .queryParam("gender", string)
                .encode()
                .toUriString();

        ResponseEntity<Data> response = restTemplate.exchange(urlTemplate
                , HttpMethod.GET,null ,Data.class);

        Data responseData = response.getBody();

        userRepository.save(responseData.toUserEntity());
        addressRepository.save(responseData.toAddressEntity());

        return responseData;
    }

    public Data getWexlFemaleUserData(String string){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Map<String, String> params = new HashMap<>();
        params.put("gender", string);
        params.put("format", "json");

        String urlTemplate = UriComponentsBuilder.fromHttpUrl("https://randomuser.me/api/")
                .queryParam("format", "json")
                .queryParam("gender", string)
                .encode()
                .toUriString();

        ResponseEntity<Data> response = restTemplate.exchange(urlTemplate
                , HttpMethod.GET,null ,Data.class);
        Data resultData= response.getBody();

        List<Result> newResult = resultData.getResults();
        Name newName = newResult.get(0).getName();
        String first = newName.getFirst();
        String last = newName.getLast();

        String newFirst = "WeXL" + first;
        String newLast = "WeXL" + last;

        newName.setFirst(newFirst);
        newName.setLast(newLast);

        userRepository.save(resultData.toUserEntity());
        addressRepository.save(resultData.toAddressEntity());

        return resultData;
    }

}
