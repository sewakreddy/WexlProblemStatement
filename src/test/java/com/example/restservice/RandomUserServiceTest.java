package com.example.restservice;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



@ExtendWith(MockitoExtension.class)
class RandomUserServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private Data data;

    @Test
    void shouldGetFemaleUserData() {
        final String gender = "female";
        Result results = Result.builder().gender("female").email("temp@123").build();
        Data data = Data.builder()
                .results(List.of(results))
                .build();

        final String expectedResponse = data.getResults().get(0).getGender();

        var responseEntity = new ResponseEntity<>(data,HttpStatus.ACCEPTED);
        Mockito.when(restTemplate.exchange(
                        ArgumentMatchers.anyString(),
                        ArgumentMatchers.any(HttpMethod.class),
                        ArgumentMatchers.any(),
                        ArgumentMatchers.<Class<Data>>any())
                )
                .thenReturn(responseEntity);

        RandomUserService randomUserService = new RandomUserService(restTemplate);
        final Data actualResponseData = randomUserService.getFemaleUserData(gender);
        final String actualResponse = actualResponseData.getResults().get(0).getGender();

        assertThat(actualResponse).isEqualTo(expectedResponse);
    }

    @Test
    void shouldGetWexlFemaleUserData(){
            final String gender = "female";
            Name name = Name.builder().first("Sewak").last("Reddy").build();
            Result results = Result.builder().gender("female").name(name).email("temp@123").build();
            Data data = Data.builder()
                    .results(List.of(results))
                    .build();

            final String expectedResponseFirstName = "WeXL" + data.getResults().get(0).getName().getFirst();
            final String expectedResponseLastName = "WeXL"+ data.getResults().get(0).getName().getLast();

            var responseEntity = new ResponseEntity<>(data,HttpStatus.ACCEPTED);
            Mockito.when(restTemplate.exchange(
                            ArgumentMatchers.anyString(),
                            ArgumentMatchers.any(HttpMethod.class),
                            ArgumentMatchers.any(),
                            ArgumentMatchers.<Class<Data>>any())
                    )
                    .thenReturn(responseEntity);

            RandomUserService randomUserService = new RandomUserService(restTemplate);
            final Data actualResponseData = randomUserService.getWexlFemaleUserData(gender);
            final String actualResponseFirstName = actualResponseData.getResults().get(0).getName().getFirst();
            final String actualResponseLastName = actualResponseData.getResults().get(0).getName().getLast();

            assertThat(actualResponseFirstName).isEqualTo(expectedResponseFirstName);
            assertThat(actualResponseLastName).isEqualTo(expectedResponseLastName);
    }


}