package cn.xuqplus.jpademo;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ATest1 {

  @Test
  public void a() {
    Optional<User> optional = Optional.empty();
    try {
      optional.get();
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    System.out.println();
  }

  @Test
  public void a1() {
    Optional<User> optional = Optional.of(null);
    try {
      optional.get();
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    System.out.println();
  }

  @Test
  public void a2() {
    Optional<User> optional = Optional.ofNullable(null);
    try {
      optional.get();
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    System.out.println();
  }

  @Test
  public void a3() {
    Optional<User> optional = Optional.ofNullable(new User().setId(1L).setName("007"));
    try {
      User user = optional.get();
      System.out.println(user.toString());
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    System.out.println();
  }

  @Test
  public void a4() {
    Optional<User> optional = Optional.ofNullable(new User().setId(1L).setName("007"));
    try {
      String n = optional.map(user -> user.getName())
              .map(name -> name.toLowerCase())
              .orElse("原来是空的呀");
      System.out.println(n);
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    System.out.println();
  }

  @Test
  public void a5() {
    Optional<User> optional = Optional.ofNullable(new User().setId(1L).setName(null));
    try {
      String n = optional.map(user -> user.getName())
              .map(name -> name.toLowerCase())
              .orElse("原来是空的呀");
      System.out.println(n);
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    System.out.println();
  }

  @Test
  public void a6() {
    Optional<User> optional = Optional.ofNullable(null);
    try {
      User user = optional.orElse(new User().setId(100L).setName("空的"));
      System.out.println(user);
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    System.out.println();
  }

  @Test
  public void a7() {
    Optional<User> optional = Optional.ofNullable(null);
    try {
      User user = optional.orElseThrow(() -> new RuntimeException("没有值的异常"));
      System.out.println(user);
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    System.out.println();
  }

  public static class User {
    public Long id;
    public String name;

    public Long getId() {
      return id;
    }

    public User setId(Long id) {
      this.id = id;
      return this;
    }

    public String getName() {
      return name;
    }

    public User setName(String name) {
      this.name = name;
      return this;
    }

    @Override
    public String toString() {
      return "User{" +
              "id=" + id +
              ", name='" + name + '\'' +
              '}';
    }
  }
}