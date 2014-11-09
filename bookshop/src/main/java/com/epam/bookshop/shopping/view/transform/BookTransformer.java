package com.epam.bookshop.shopping.view.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import com.epam.bookshop.book.domain.Book;
import com.epam.bookshop.shopping.view.controller.ShowBookController;
import com.epam.bookshop.shopping.view.model.BookDetailsView;
import com.epam.bookshop.shopping.view.model.BookSummaryView;

@Component
public class BookTransformer {
    private ConversionService conversionService;

    @Autowired
    public BookTransformer(ConversionService conversionService) {
        super();
        this.conversionService = conversionService;
    }

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
        result.setBookFormat(conversionService.convert(book.getFormat(), String.class));
        return result;
    }

    public BookDetailsView transformBookToDetails(Book book) {
        BookDetailsView result = new BookDetailsView();
        result.setSynopsis(book.getSynopsis());
        return result;
    }
}
