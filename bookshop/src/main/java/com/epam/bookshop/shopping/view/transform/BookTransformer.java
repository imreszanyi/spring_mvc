package com.epam.bookshop.shopping.view.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.shopping.view.model.BookSummaryView;

@Component
public class BookTransformer {
	public List<BookSummaryView> transformBooks(List<Book> books) {
		List<BookSummaryView> result = new ArrayList<BookSummaryView>();
		for (Book book : books) {
			result.add(transformBook(book));
		}
		return result;
	}

	private BookSummaryView transformBook(Book book) {
		BookSummaryView result = new BookSummaryView();
		result.setAuthor(book.getAuthor());
		result.setTitle(book.getTitle());
		return result;
	}
}
