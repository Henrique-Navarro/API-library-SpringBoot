package com.api.library.controllers;

import com.api.library.models.Book;
//import com.api.library.repositories.BookRepository;
import com.api.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class Control {
    @Autowired
    private BookService bookService;      /*injeção de dependência*/

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("redirect:/searchAll");
    }
    
    //ROUTES
    @GetMapping("/searchAll")
    public ModelAndView searchAll() {
        ModelAndView mv = new ModelAndView("index");
        List<Book> bookList = this.bookService.getBookList();
        mv.addObject("bookList", bookList);
        return mv;
    }

    @GetMapping("/searchByName")
    @ResponseBody
    public ResponseEntity<List<Book>> searchByName(@RequestParam(name = "name") String name) {
        //ModelAndView mv = new ModelAndView("index");
        List<Book> bookListModal = this.bookService.searchByName(name);
        //mv.addObject("bookListModal", bookListModal);
        //return mv;
        return new ResponseEntity<List<Book>>(bookListModal, HttpStatus.OK);
    }
}
