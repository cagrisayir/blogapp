package com.cagrisayir.blogapp.service.impl;

import com.cagrisayir.blogapp.entity.Comment;
import com.cagrisayir.blogapp.entity.Post;
import com.cagrisayir.blogapp.exception.BlogAPIException;
import com.cagrisayir.blogapp.exception.ResourceNotFoundException;
import com.cagrisayir.blogapp.payload.CommentDto;
import com.cagrisayir.blogapp.repository.CommentRepository;
import com.cagrisayir.blogapp.repository.PostRepository;
import com.cagrisayir.blogapp.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);

        // retrieve post entity by id
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", Long.toString(postId)));

        // set post to comment entity
        comment.setPost(post);

        // save comment entity to database
        Comment savedComment = commentRepository.save(comment);

        return mapToDto(savedComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        // retrieve comments by post id
        List<Comment> comments = commentRepository.findByPostId(postId);

        return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", Long.toString(postId)));

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment", "id", Long.toString(commentId)));

        if (comment.getPost().getId() != post.getId())
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment doesn't belong to post.");

        return mapToDto(comment);
    }

    @Override
    public CommentDto updateComment(long postId, long commentId, CommentDto commentRequest) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", Long.toString(postId)));

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment", "id", Long.toString(commentId)));

        if (comment.getPost().getId() != post.getId())
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment doesn't belong to post.");

        comment.setName(commentRequest.getName());
        comment.setBody(commentRequest.getBody());
        comment.setEmail(commentRequest.getEmail());

        var updatedComment = commentRepository.save(comment);
        return mapToDto(updatedComment);
    }

    @Override
    public void deleteComment(long postId, long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", Long.toString(postId)));

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment", "id", Long.toString(commentId)));

        if (comment.getPost().getId() != post.getId())
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment doesn't belong to post.");

        commentRepository.delete(comment);
    }

    private CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setBody(comment.getBody());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        comment.setName(commentDto.getName());
        return comment;
    }
}
