package com.cifnews.train.controller;

import com.cifnews.train.dto.PostDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;



import static org.hamcrest.Matchers.*;
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
        this.webClient.get().uri("/posts").accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBodyList(PostDto.class)
                .hasSize(10);

    }

    @Test
    public void testGetPostGivenID() throws Exception {

        this.webClient.get().uri("/posts/51")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id",is(51));

    }
}
