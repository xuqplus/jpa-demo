package cn.xuqplus.jpademo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Api
@RestController
@RequestMapping("b")
public class BController {

  Random random = new Random();

  @GetMapping("dosth")
  public Object dosth() throws InterruptedException {
    int mills = random.nextInt(1000);
    Thread.sleep(mills);
    return "ok-" + mills;
  }
}
