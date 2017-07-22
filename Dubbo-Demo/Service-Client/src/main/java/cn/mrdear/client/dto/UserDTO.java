package cn.mrdear.client.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户DTO,用于Service层传输
 * @author Niu Li
 * @since 2017/6/12
 */
@Data
public class UserDTO implements Serializable{

  private static final long serialVersionUID = 4086492518942464226L;

  private Long id;

  private String username;

  private String password;

  private Integer age;

  private String nickname;

  private String mail;

  private String memo;

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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }
}
