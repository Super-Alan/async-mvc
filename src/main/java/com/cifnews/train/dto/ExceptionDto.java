package com.cifnews.train.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by lucky on 2018/4/20.
 */
@Getter
@Setter
@Builder
public class ExceptionDto {
    private String code;
    private String message;
}
