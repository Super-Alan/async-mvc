package com.cifnews.train.repository;

import com.cifnews.train.entity.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lucky
 * Created by lucky on 2018/4/18.
 */
@Repository
public interface PostRepository extends PagingAndSortingRepository<Post,Integer>{

}
