package com.cagrisayir.blogapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok
@Data // For getter, setter, Constructor, toString and HashCode.
@AllArgsConstructor
@NoArgsConstructor
// jpa
@Entity
@Table(name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;

}
