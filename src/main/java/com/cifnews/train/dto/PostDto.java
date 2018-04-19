package com.cifnews.train.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lucky
 * Created by lucky on 2018/4/18.
 */
@Data
public class PostDto implements Serializable {
    private String id;
    @NotEmpty
    @Size(min = 6, max = 256)
    private String title;
    private String content;
    private String image;
    private String author;
    private Date createdDate;
}
