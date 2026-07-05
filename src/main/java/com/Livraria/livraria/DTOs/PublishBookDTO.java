package com.Livraria.livraria.DTOs;

import com.Livraria.livraria.objectvalue.LiteraryGenreEnum;

public record PublishBookDTO(String title, String description, LiteraryGenreEnum literaryGenre) {
}
