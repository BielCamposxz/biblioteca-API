package com.Livraria.livraria.DTOs.user;

import com.Livraria.livraria.objectvalue.RoleEnum;

public record CreateUserDTO(String name, String login, String password, RoleEnum role) {
}
