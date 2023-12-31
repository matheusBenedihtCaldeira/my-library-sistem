package com.mylibrary.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_books_collection")
@AllArgsConstructor
@NoArgsConstructor
public class BooksCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private String notes;

    public BooksCollection(Book book, String notes) {
        this.book = book;
        this.notes = notes;
    }
}
