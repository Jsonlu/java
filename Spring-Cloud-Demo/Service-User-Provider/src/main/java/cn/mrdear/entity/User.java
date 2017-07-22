package cn.mrdear.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Niu Li
 * @since 2017/6/3
 */
@Data
@NoArgsConstructor
@ToString
@Entity
public class User implements Serializable{

  private static final long serialVersionUID = -2885884654600114856L;

  @Id
  @GeneratedValue
  private Long id;

  private String username;

  private String password;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
