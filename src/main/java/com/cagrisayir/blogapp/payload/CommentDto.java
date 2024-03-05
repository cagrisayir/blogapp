package com.cagrisayir.blogapp.payload;

import lombok.Data;

@Data // For getter, setter, Constructor, toString and HashCode.
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}
