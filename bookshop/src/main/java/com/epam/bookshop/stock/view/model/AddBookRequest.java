package com.epam.bookshop.stock.view.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.epam.bookshop.book.domain.BookFormat;

public class AddBookRequest {
	@NotNull
	@Size(min = 2, max = 255)
	private String title;
	@NotNull
	@Size(min = 2, max = 255)
	private String author;
	private String synopsis;
	@NotNull
	private BookFormat format;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public BookFormat getFormat() {
		return format;
	}

	public void setFormat(BookFormat format) {
		this.format = format;
	}

}
