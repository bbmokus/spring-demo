package com.example.demo.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArticleControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void getArticleNotFound() {
        ResponseEntity<String> respEntity = restTemplate.getForEntity("/articles/1", String.class);
        assertThat(respEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}