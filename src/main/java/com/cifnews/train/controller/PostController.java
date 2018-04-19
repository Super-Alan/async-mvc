package com.cifnews.train.controller;

import com.cifnews.train.dto.PostDto;
import com.cifnews.train.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author lucky
 * Created by lucky on 2018/4/18.
 */
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public Flux<PostDto> getPostList(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10")  int size){
        return Flux.fromIterable(postService.listPosts(page,size));
    }

    @GetMapping("/posts/{id}")
    public Mono<PostDto> getPost(@PathVariable Integer id){
        return Mono.just(postService.getPostByID(id));
    }

    @PutMapping("/posts")
    public Mono<PostDto> updatePost(@RequestBody PostDto postDto){
        return Mono.just(postService.updatePost(postDto));
    }

    @DeleteMapping("/posts/{id}")
    public Mono<ResponseEntity<String>> deletePost(@PathVariable Integer id){
        postService.deletePost(id);
        return Mono.just(new ResponseEntity<>("deleted:"+id, HttpStatus.ACCEPTED));

    }
}
