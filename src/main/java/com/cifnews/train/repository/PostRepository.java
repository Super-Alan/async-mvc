package com.cifnews.train.repository;

import com.cifnews.train.entity.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author lucky
 * Created by lucky on 2018/4/18.
 */
public interface PostReporitory  extends PagingAndSortingRepository<Post,Integer>{

}
