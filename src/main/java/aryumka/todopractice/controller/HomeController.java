package aryumka.todopractice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeController {
  @GetMapping("/")
  public String home() {
    return "hello";
  }
}
