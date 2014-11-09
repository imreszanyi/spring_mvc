package com.epam.bookshop.stock.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.bookshop.book.service.BookWriteService;
import com.epam.bookshop.stock.view.model.AddBookRequest;
import com.epam.bookshop.stock.view.transform.AddBookRequestTransformer;

@Controller
public class AddBookPostController {
    private BookWriteService bookWriteService;
    private AddBookRequestTransformer addBookRequestTransformer;

    @Autowired
    public AddBookPostController(BookWriteService bookWriteService, AddBookRequestTransformer addBookRequestTransformer) {
        super();
        this.bookWriteService = bookWriteService;
        this.addBookRequestTransformer = addBookRequestTransformer;
    }

    @ModelAttribute("addBookRequest")
    public AddBookRequest createListBooksModel(AddBookRequest addBookRequest) {
        return new AddBookRequest();
    }

    @RequestMapping(value = "/addBookPost.html", method = RequestMethod.POST)
    private String createBook(AddBookRequest addBookRequest, RedirectAttributes redirectAttributes) {
        bookWriteService.saveBook(addBookRequestTransformer.transformAddBookRequestToBook(addBookRequest));
        redirectAttributes.addFlashAttribute("message", String.format("Book '%s' of '%s' saved!", addBookRequest.getTitle(), addBookRequest.getAuthor()));
        return "redirect:addBookForm.html";
    }

}
