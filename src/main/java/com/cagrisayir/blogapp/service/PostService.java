package com.cagrisayir.blogapp.service;

import com.cagrisayir.blogapp.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
