package com.Livraria.livraria.repository.user;

import com.Livraria.livraria.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.LinkedList;
import java.util.List;

@Repository
public class UserRepository {
    List<UserEntity> users = new LinkedList<>();

    public void saveNewUser(UserEntity user) {
        this.users.add(user);
    }

    public List<UserEntity> getAllUsers() {
        return this.users;
    }

    public int getLastUserId() {
        return users.isEmpty() ? 1 : users.getLast().getId() + 1;
    }

    public UserDetails getUserByLogin(String login) {
        return this.users.stream().filter(x -> x.getLogin().equals(login)).findFirst().orElse(null);
    }

    public UserEntity userByLogin(String login) {
        return this.users.stream().filter(x -> x.getLogin().equals(login)).findFirst().orElse(null);
    }
}
