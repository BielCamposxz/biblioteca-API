package com.Livraria.livraria.entity;

import com.Livraria.livraria.objectvalue.LiteraryGenreEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class BookEntity {
    private int id;
    private int authorId;
    private String title;
    private String description;
    private LiteraryGenreEnum literaryGenre;
}
