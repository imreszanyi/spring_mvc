package com.epam.bookshop.stock.view.transform;

import org.springframework.stereotype.Component;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.stock.view.model.AddBookRequest;

@Component
public class AddBookRequestTransformer {
	public Book transformAddBookRequestToBook(AddBookRequest addBookRequest) {
		Book result = new Book();
		result.setAuthor(addBookRequest.getAuthor());
		result.setSynopsis(addBookRequest.getSynopsis());
		result.setTitle(addBookRequest.getTitle());
		result.setFormat(addBookRequest.getFormat());
		return result;

	}
}
