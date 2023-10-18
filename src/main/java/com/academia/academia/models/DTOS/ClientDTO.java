package com.academia.academia.models.DTOS;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public record ClientDTO(String nome, String email, String cpf, String dataDeNascimento, Integer idPlano, String numeroTelefone) {
}
