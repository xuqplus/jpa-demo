package cn.xuqplus.jpademo.entity;

import javax.persistence.*;

@Entity
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  String id;
  String name;
  @Version
  Long version;

  public UserEntity setId(String id) {
    this.id = id;
    return this;
  }

  public UserEntity setName(String name) {
    this.name = name;
    return this;
  }

  public UserEntity setVersion(Long version) {
    this.version = version;
    return this;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Long getVersion() {
    return version;
  }
}
