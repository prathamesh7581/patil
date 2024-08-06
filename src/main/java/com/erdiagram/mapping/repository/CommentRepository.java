package com.erdiagram.mapping.repository;

import com.erdiagram.mapping.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}