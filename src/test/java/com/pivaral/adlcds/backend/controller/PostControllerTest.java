package com.pivaral.adlcds.backend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.pivaral.adlcds.backend.domain.model.Post;
import com.pivaral.adlcds.backend.domain.repository.PostRepository;
import java.util.Collections;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class PostControllerTest {

  @Mock
  private PostRepository postRepository;

  @InjectMocks
  private PostController target;

  @Test
  void validateSuccessPostCreation() {
    var mockedPost = Mockito.mock(Post.class);
    Mockito.when(postRepository.save(Mockito.any()))
        .thenReturn(mockedPost);
    var response = target.createPost(mockedPost);
    Mockito.verify(postRepository)
        .save(Mockito.any());
    assertNotNull(response);
  }

  @Test
  void validateSuccessPostUpdatew() {
    var mockedPost = Mockito.mock(Post.class);
    Mockito.when(postRepository.save(Mockito.any()))
        .thenReturn(mockedPost);
    var response = target.updatePostById(1L, mockedPost);
    Mockito.verify(postRepository)
        .save(Mockito.any());
    assertNotNull(response);
  }

  @Test
  void validateSuccessFindAllPosts() {
    var mockedPost = Mockito.mock(Post.class);
    Mockito.when(postRepository.findAll())
        .thenReturn(Collections.singletonList(mockedPost));
    var response = target.findAllPosts();
    Mockito.verify(postRepository)
        .findAll();
    assertNotNull(response);
    assertEquals(1, response.size());
  }

  @Test
  void validateSuccessFindPostById() {
    var mockedPost = Mockito.mock(Post.class);
    Mockito.when(postRepository.findById(Mockito.anyLong()))
        .thenReturn(Optional.of(mockedPost));
    var response = target.findPostById(Mockito.anyLong());
    Mockito.verify(postRepository)
        .findById(Mockito.anyLong());
    assertNotNull(response);
  }

  @Test
  void validateSuccessDeletePostById() {
    Mockito.doNothing()
        .when(postRepository)
        .deleteById(Mockito.anyLong());
    target.deletePostById(Mockito.anyLong());
    Mockito.verify(postRepository)
        .deleteById(Mockito.anyLong());
  }
}
