package com.oldfashionpound;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResolverTest {


  @Test
  void sum() {
    String expression = "5p 17s 8d + 3p 4s 10d";
    assertThat(Resolver.resolve(expression), is("9p 2s 6d"));
  }

  @Test
  void sumIncompleteAmount() {
    String expression = "5p 17s 8d + 4s 10d";
    assertThat(Resolver.resolve(expression), is("6p 2s 6d"));
  }

  @Test
  void diff() {
    String expression = "5p 17s 8d - 3p 4s 10d";
    assertThat(Resolver.resolve(expression), is("2p 12s 10d"));
  }

  @Test
  void diffIncompleteAmount() {
    String expression = "5p 17s 8d - 3p 4s";
    assertThat(Resolver.resolve(expression), is("2p 13s 8d"));
  }

  @Test
  void mul() {
    String expression = "5p 17s 8d * 2";
    assertThat(Resolver.resolve(expression), is("11p 15s 4d"));
  }

  @Test
  void mulIncompleteAmount() {
    String expression = "5p 17s * 2";
    assertThat(Resolver.resolve(expression), is("11p 14s"));
  }

  @Test
  void div() {
    String expression = "5p 17s 8d / 3";
    assertThat(Resolver.resolve(expression), is("1p 19s 2d ( 2d )"));
  }

  @Test
  void anotherDiv() {
    String expression = "18p 16s 1d / 15 ";
    assertThat(Resolver.resolve(expression), is("1p 5s ( 1s 1d )"));
  }

  @Test
  void tooLongExpr() {
    String expression = "7p 17s 8d + 3p 4s 10d + 10p 4s 10d";
    assertThrows(UnsupportedOperationException.class, () -> Resolver.resolve(expression));
  }

  @ParameterizedTest
  @ValueSource(strings = {"7p 17s 8d", "  ", "", "7p 17s 8d ^ 2"})
  void invalidOperation(String expression) {
    assertThrows(UnsupportedOperationException.class, () -> Resolver.resolve(expression));
  }
}
