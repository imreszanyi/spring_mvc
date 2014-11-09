package com.epam.bookshop.shopping.view.model;

public class BookDetailsModel {
	private BookSummaryView bookSummary;
	private BookDetailsView bookDetails;

	public BookDetailsModel(BookSummaryView bookSummary, BookDetailsView bookDetails) {
		super();
		this.bookSummary = bookSummary;
		this.bookDetails = bookDetails;
	}

	public BookSummaryView getBookSummary() {
		return bookSummary;
	}

	public BookDetailsView getBookDetails() {
		return bookDetails;
	}

}
