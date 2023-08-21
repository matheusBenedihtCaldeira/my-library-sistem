package com.mylibrary.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksCollectionDTO {

    private Long bookId;
    private String notes;
}