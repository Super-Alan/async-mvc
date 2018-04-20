package com.cifnews.train.controller;

import com.cifnews.train.dto.PostDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;



/**
 * Created by lucky on 2018/4/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerTests {

    @Autowired
    private WebTestClient webClient;


    @Test
    public void testGetPostList() throws Exception {
        this.webClient.get().uri("/posts?page=0&size=6").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBodyList(PostDto.class)
                .hasSize(6);

    }

    @Test
    public void testGetPostGivenID() throws Exception {

        this.webClient.get().uri("/posts/53")
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$.id")
                .isEqualTo("53");

    }
}
