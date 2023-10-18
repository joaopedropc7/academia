package com.academia.academia.models.DTOS;

import com.academia.academia.models.UserRole;

public record RegisterDTO(String login, String senha, UserRole userRole) {
}
