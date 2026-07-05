package com.Livraria.livraria.DTOs;

import com.Livraria.livraria.objectvalue.LiteraryGenreEnum;

public record UpdateBookDTO(String title, String description, LiteraryGenreEnum literaryGenre) {
}
