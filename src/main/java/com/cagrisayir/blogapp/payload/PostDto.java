package com.cagrisayir.blogapp.payload;

import lombok.Data;

@Data // For getter, setter, Constructor, toString and HashCode.
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;
}
