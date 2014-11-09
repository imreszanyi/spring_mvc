package com.epam.bookshop.shopping.view.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.shopping.view.controller.ShowBookController;
import com.epam.bookshop.shopping.view.model.BookDetailsView;
import com.epam.bookshop.shopping.view.model.BookSummaryView;

@Component
public class BookTransformer {

	public List<BookSummaryView> transformBooksToSummaries(List<Book> books) {
		List<BookSummaryView> result = new ArrayList<BookSummaryView>();
		for (Book book : books) {
			result.add(transformBookToSummary(book));
		}
		return result;
	}

	public BookSummaryView transformBookToSummary(Book book) {
		BookSummaryView result = new BookSummaryView();
		result.setAuthor(book.getAuthor());
		result.setTitle(book.getTitle());
		result.setBookId(book.getBookId());
		result.setDetailsUrl(String.format("%s?bookId=%d", ShowBookController.REQUEST_MAPPING, book.getBookId()));
		return result;
	}

	public BookDetailsView transformBookToDetails(Book book) {
		BookDetailsView result = new BookDetailsView();
		result.setSynopsis(book.getSynopsis());
		return result;
	}
}
