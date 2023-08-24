package com.mylibrary.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_collection")
@AllArgsConstructor
@NoArgsConstructor
public class CollectionBook {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    private List<BooksCollection> booksCollection = new ArrayList<>();
}