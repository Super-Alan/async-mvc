package com.cifnews.train.service;

import com.cifnews.train.dto.PostDto;
import com.cifnews.train.entity.Post;
import com.cifnews.train.repository.PostRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;


/**
 * Created by lucky on 2018/4/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTests {
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository repository;

    @Before
    public  void setUp(){
        if(repository.count() > 0){
            return;
        }
        else {
            int i = 1;
            while (i <= 10) {
                Post post = new Post();
                post.setAuthor("Alan" + i);
                post.setContent("hello alan");
                post.setId(i);
                post.setImage("/hello.jpg");
                post.setTitle("Alan's post" + i);
                post.setCreatedDate(new Date());
                repository.save(post);
                i++;
            }
        }

    }

    @Test
    public void testListPostByPage(){
        List<PostDto> postDtos = postService.listPosts(0,1);
        assertTrue(postDtos.size() > 0);
    }

    @Test
    public void testGetPostByID(){
         PostDto post = postService.getPostByID(51);
        assertTrue(post != null);
    }

    @Test
    public void testUpdatePost(){
        PostDto postDto = postService.getPostByID(51);
        postDto.setAuthor("Steven");
        postDto = postService.updatePost(postDto);
        assertTrue(postDto.getAuthor().equals("Steven"));
    }
}
