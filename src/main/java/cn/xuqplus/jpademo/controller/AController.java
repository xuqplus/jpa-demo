package cn.xuqplus.jpademo.controller;

import cn.xuqplus.jpademo.entity.UserEntity;
import cn.xuqplus.jpademo.repository.UserRepository;
import cn.xuqplus.jpademo.service.UserService;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Api
@RestController
@RequestMapping("user")
public class AController {
  @Autowired
  UserService userService;
  @Autowired
  UserRepository userRepository;

  @GetMapping("add")
  public Object add(String id, String name) {
    UserEntity user = new UserEntity();
    user.setId(id);
    user.setName(name);
    userRepository.save(user);
    return JSON.toJSON(user);
  }

  @GetMapping("modify")
  @Transactional
  public Object modify(String id, String name) {
    UserEntity user = userRepository.getOne(id);
    UserEntity user1 = userRepository.getOne(id);
    user.setName(name);
    userRepository.save(user);
    System.out.println(user);
    System.out.println(user1);
    return user.toString();
  }

  @GetMapping("modifyFlush")
  @Transactional
  public Object modifyFlush(String id, String name) {
    UserEntity user = userRepository.getOne(id);
    UserEntity user1 = userRepository.getOne(id);
    user.setName(name);
    userRepository.saveAndFlush(user);
    System.out.println(user);
    System.out.println(user1);
    return user.toString();
  }

  @GetMapping("modifyException")
  @Transactional
  public Object modifyException(String id, String name) {
    UserEntity user = userRepository.getOne(id);
    user.setName(name);
    userRepository.save(user);
    System.out.println(user);
    throw new RuntimeException("抛异常");
  }

  @GetMapping("modifyFlushException")
  @Transactional
  public Object modifyFlushException(String id, String name) {
    UserEntity user = userRepository.getOne(id);
    user.setName(name);
    userRepository.saveAndFlush(user);
    System.out.println(user);
    throw new RuntimeException("抛异常");
  }
}
