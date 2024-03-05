package com.cagrisayir.blogapp.repository;

import com.cagrisayir.blogapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}