package spring.springaop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "password", nullable = false, length = 100)
  private String password;

  @Column(name = "full_name", nullable = false, length = 100)
  private String fullName;

  @Column(name = "email", nullable = false, length = 100)
  private String email;

  @Column(name = "user_role", nullable = false)
  private Integer userRole;

  @Column(name = "branch_id")
  private Integer branchId;

  @Column(name = "create_user_id")
  private Integer createUserId;

  @Column(name = "create_date", nullable = false)
  private Instant createDate;

  @Column(name = "update_user_id")
  private Integer updateUserId;

  @Column(name = "update_date", nullable = false)
  private Instant updateDate;

  @Column(name = "delete_flag", nullable = false)
  private Boolean deleteFlag = false;

}