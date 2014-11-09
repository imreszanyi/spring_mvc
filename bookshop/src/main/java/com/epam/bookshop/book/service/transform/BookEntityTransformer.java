package com.epam.bookshop.book.service.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.book.repository.domain.BookEntity;

@Component
public class BookEntityTransformer {
	public List<Book> transformBookEntities(Iterable<BookEntity> books) {
		List<Book> result = new ArrayList<Book>();
		for (BookEntity book : books) {
			result.add(transformBookEntity(book));
		}
		return result;
	}

	private Book transformBookEntity(BookEntity book) {
		Book result = new Book();
		result.setAuthor(book.getAuthor());
		result.setTitle(book.getTitle());
		return result;
	}
}
