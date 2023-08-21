package com.mylibrary.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionDTO {

    private Long userId;
    private List<BooksCollectionDTO> booksCollectionDTOList;
}