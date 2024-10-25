package com.pivaral.adlcds.backend.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PostTest {

  @Test
  void validateCorrectPost() {
    var target = new Post();
    target.setPostId(1L);
    target.setDescription("test");
    var targetDescription = target.getDescription();
    assertEquals("test", targetDescription);
    assertEquals(String.class, target.getDescription().getClass());
    var targetId = target.getPostId();
    assertEquals(1L, targetId);
    assertEquals(Long.class, target.getPostId().getClass());
  }

  @Test
  void validateEqualsObjects() {
    var target = new Post();
    target.setPostId(1L);
    target.setDescription("test");
    var target2 = new Post();
    target2.setPostId(1L);
    target2.setDescription("test");
    var equals = target.equals(target2);
    assertTrue(equals);
  }

  @Test
  void validateNotEqualsObjects() {
    var target = new Post();
    target.setPostId(1L);
    target.setDescription("test");
    var target2 = new Post();
    target2.setPostId(1L);
    target2.setDescription("test2");
    var equals = target.equals(target2);
    assertFalse(equals);
  }

  @Test
  void validateToString() {
    var target = new Post();
    target.setPostId(1L);
    target.setDescription("test");
    assertEquals("Post(postId=1, description=test)", target.toString());
  }
}
