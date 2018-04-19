package com.cifnews.train.mapper.impl;

import com.cifnews.train.dto.PostDto;
import com.cifnews.train.entity.Post;
import com.cifnews.train.mapper.IMapperEntityDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lucky
 * Created by lucky on 2018/4/18.
 */
@Component
public class PostMapper implements IMapperEntityDto<Post,PostDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto mapEntityIntoDTO(Post entity) {
        return modelMapper.map(entity,PostDto.class);
    }

    @Override
    public Post mapDtoToEntity(PostDto entity) {
        return modelMapper.map(entity,Post.class);
    }
}
