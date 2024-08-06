package com.erdiagram.mapping.controller;

import com.erdiagram.mapping.entity.Comment;
import com.erdiagram.mapping.entity.Post;
import com.erdiagram.mapping.repository.CommentRepository;
import com.erdiagram.mapping.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private CommentRepository commentRepository;

    private PostRepository postRepository;

    public CommentController(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(
            @RequestBody Comment comment,
            @RequestParam long postId
    ) {
        Post post = postRepository.findById(postId).get();
        comment.setPost(post);
        return ResponseEntity.ok(commentRepository.save(comment));
    }
}
