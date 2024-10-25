package com.pivaral.adlcds.backend.controller;

import com.pivaral.adlcds.backend.domain.model.Post;
import com.pivaral.adlcds.backend.domain.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

  private final PostRepository postRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Post createPost(@RequestBody final Post post) {
    return postRepository.save(post);
  }

  @DeleteMapping("/{postId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletePostById(@PathVariable("postId") final Long postId) {
    postRepository.deleteById(postId);
  }

  @GetMapping("/{postId}")
  @ResponseStatus(HttpStatus.OK)
  public Post findPostById(@PathVariable("postId") final Long postId) {
    return postRepository.findById(postId)
        .orElse(null);
  }

  @PutMapping("/{postId}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public Post updatePostById(@PathVariable("postId") final Long postId,
                             @RequestBody final Post post) {
    post.setPostId(postId);
    return postRepository.save(post);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Post> findAllPosts() {
    return postRepository.findAll();
  }
}
