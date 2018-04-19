package com.cifnews.train.service;

import com.cifnews.train.dto.PostDto;
import com.cifnews.train.entity.Post;
import com.cifnews.train.mapper.impl.PostMapper;
import com.cifnews.train.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lucky
 * Created by lucky on 2018/4/18.
 */
@Service
public class PostService {

    private static final Logger LOG = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository repository;
    @Autowired
    private PostMapper mapper;
    /**
     * 获取特定分页数据
     * @param page >=0
     * @param size >0
     * @return
     */
    @Cacheable(value = "Post",key ="{'PageList',#root.args}")
    public List<PostDto> listPosts(@Min(0) int page,
                                   @Min(1) int size ){

        Pageable pageable = PageRequest.of(page,size);
        return repository.findAll(pageable)
                    .stream()
                    .map(mapper::mapEntityIntoDTO)
                    .collect(Collectors.toList());
    }

    /**
     * 根据ID 获取 Post
     * @param id
     * @return
     */
    @Cacheable(value = "Post",key="{'Detail',#root.args}")
    public  PostDto getPostByID(Integer id){


        Post post = repository.findById(id).get();
        if(post != null) {
            return mapper.mapEntityIntoDTO(post);
        }else{
            return null;
        }
    }

    @CachePut(value = "Post",key ="{'Detail',#postDto.id}")
    public PostDto updatePost(PostDto postDto){
        Post post = mapper.mapDtoToEntity(postDto);
        post = repository.save(post);
        LOG.info("Save post to db success {}",post);
        return mapper.mapEntityIntoDTO(post);
    }

    @CacheEvict(value = "Post",key="{'Detail',#root.args}")
    public  void deletePost(Integer id){
        repository.deleteById(id);
        LOG.info("delete post to db success {}",id);
    }



}
