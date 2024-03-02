package com.cagrisayir.blogapp.service.impl;

import com.cagrisayir.blogapp.entity.Post;
import com.cagrisayir.blogapp.payload.PostDto;
import com.cagrisayir.blogapp.repository.PostRepository;
import com.cagrisayir.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        // convert Dto to Entity
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post newPost = postRepository.save(post);

        // Convert entity to DTO
        var postResponse = new PostDto();
        postResponse.setId(newPost.getId());
        postResponse.setTitle(newPost.getTitle());
        postResponse.setContent(newPost.getContent());
        postResponse.setDescription(newPost.getDescription());

        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : posts) {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setContent(post.getContent());
            postDto.setDescription(post.getDescription());
            postDtos.add(postDto);
        }
        return postDtos;
    }
}
