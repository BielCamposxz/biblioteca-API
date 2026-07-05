package com.Livraria.livraria.DTOs.book;

import com.Livraria.livraria.objectvalue.LiteraryGenreEnum;

public record PublishBookDTO(String title, String description, LiteraryGenreEnum literaryGenre) {
}
