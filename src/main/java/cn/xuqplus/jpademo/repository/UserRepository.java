package cn.xuqplus.jpademo.repository;

import cn.xuqplus.jpademo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
