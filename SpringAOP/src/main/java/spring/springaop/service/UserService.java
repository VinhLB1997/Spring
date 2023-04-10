package spring.springaop.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.springaop.entity.User;
import spring.springaop.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(Integer id) {
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not Found"));
  }

  @Transactional
  public User save(User user) {
    return userRepository.save(user);
  }

  @Transactional
  public void deleteById(Integer id) {
    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not Found"));
    userRepository.deleteById(id);
  }
}
