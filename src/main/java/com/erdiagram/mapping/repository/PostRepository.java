package com.erdiagram.mapping.repository;

import com.erdiagram.mapping.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}