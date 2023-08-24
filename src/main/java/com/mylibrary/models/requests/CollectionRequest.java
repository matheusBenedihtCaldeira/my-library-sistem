package com.mylibrary.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionRequest {
    private Long userId;
    private BooksCollectionRequest bookCollection;
}