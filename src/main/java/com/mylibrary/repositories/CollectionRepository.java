package com.mylibrary.repositories;

import com.mylibrary.models.entities.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection, Long> {
}