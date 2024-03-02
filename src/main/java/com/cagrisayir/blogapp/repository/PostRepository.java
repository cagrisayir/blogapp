package com.cagrisayir.blogapp.repository;

import com.cagrisayir.blogapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository // We don't have to. By extending JpaRepository we've already added it.
public interface PostRepository extends JpaRepository<Post, Long> {
    // JpaRepository includes all CRUD implementations.
}
