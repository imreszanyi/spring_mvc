package com.epam.bookshop.book.repository.dao;

import org.springframework.data.repository.CrudRepository;

import com.epam.bookshop.book.repository.domain.BookEntity;

public interface BookDao extends CrudRepository<BookEntity, Long> {

}
