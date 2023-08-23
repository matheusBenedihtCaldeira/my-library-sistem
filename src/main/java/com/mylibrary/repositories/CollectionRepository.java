package com.mylibrary.repositories;

import com.mylibrary.models.entities.CollectionBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<CollectionBook, Long> {
}