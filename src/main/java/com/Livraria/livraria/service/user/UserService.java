package com.Livraria.livraria.service.user;

import com.Livraria.livraria.DTOs.user.CreateUserDTO;
import com.Livraria.livraria.entity.UserEntity;
import com.Livraria.livraria.objectvalue.RoleEnum;
import com.Livraria.livraria.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(CreateUserDTO createUserDTO) {
        int id = this.userRepository.getLastUserId();
        var password = new BCryptPasswordEncoder().encode(createUserDTO.password());

        this.userRepository.saveNewUser(new UserEntity(
                id,
                createUserDTO.name(),
                createUserDTO.login(),
                password,
                createUserDTO.role()
        ));
    }

    public List<UserEntity> getAllUsers() {
        return this.userRepository.getAllUsers();
    }

    public void createFistUser() {

        String name = "admin";
        String login = "admin";
        String password = new BCryptPasswordEncoder().encode("123");
        RoleEnum role = RoleEnum.ADMIN;


        this.userRepository.saveNewUser(new UserEntity(
                1,
                name,
                login,
                password,
                role
        ));
    }
}
