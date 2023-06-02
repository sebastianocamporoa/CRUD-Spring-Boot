package com.globalhitss.PruebaTecnica.interfaces;

import com.globalhitss.PruebaTecnica.repository.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository <User,Integer>{
    List<User> findAllByStatusTrue();
    User findByStatusTrueAndId(Integer id);
}
