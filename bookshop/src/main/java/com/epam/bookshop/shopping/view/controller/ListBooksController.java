package com.epam.bookshop.shopping.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.book.service.BookSearchService;
import com.epam.bookshop.shopping.view.model.BookSummaryView;
import com.epam.bookshop.shopping.view.model.ListBooksModel;
import com.epam.bookshop.shopping.view.transform.BookTransformer;

@Controller
public class ListBooksController {
	private BookSearchService bookSearchService;
	private BookTransformer bookTransformer;

	@Autowired
	public ListBooksController(BookSearchService bookSearchService, BookTransformer bookTransformer) {
		super();
		this.bookSearchService = bookSearchService;
		this.bookTransformer = bookTransformer;
	}

	@ModelAttribute("listBooksModel")
	public ListBooksModel createListBooksModel() {
		List<Book> books = listBooks();
		List<BookSummaryView> bookViews = transformBooks(books);
		return initListBooksModel(bookViews);
	}

	@RequestMapping("/shopping.html")
	public String showBooks() {
		return "shopping";
	}

	private List<BookSummaryView> transformBooks(List<Book> books) {
		return bookTransformer.transformBooks(books);
	}

	private ListBooksModel initListBooksModel(List<BookSummaryView> bookViews) {
		return new ListBooksModel(bookViews);
	}

	private List<Book> listBooks() {
		return bookSearchService.listBooks();
	}

}
