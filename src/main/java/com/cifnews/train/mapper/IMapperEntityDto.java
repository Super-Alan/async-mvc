package com.cifnews.train.mapper;

/**
 * Created by lucky on 2018/4/18.
 */
public interface IMapperEntityDto<E, D> {
    D mapEntityIntoDTO(E entity);

    E mapDtoToEntity(D entity);
}
