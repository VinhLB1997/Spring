package spring.springaop.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springaop.entity.User;
import spring.springaop.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "users")
public class UserController {


  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
  }

  @GetMapping(path = "{userId}")
  public ResponseEntity<User> findById(@PathVariable("userId") Integer userId) {
    return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<User> insertOrUpdate(@RequestBody User user) {
    return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
  }
}
