package com.cagrisayir.blogapp.service;

import com.cagrisayir.blogapp.payload.PostDto;
import com.cagrisayir.blogapp.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePost(long id);
}
