package com.api.library.controllers;

import com.api.library.models.Author;
import com.api.library.models.Book;
import com.api.library.models.Category;
import com.api.library.services.AuthorService;
import com.api.library.services.BookService;
import com.api.library.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;
    
    @GetMapping("/edit/{id}")
    public ModelAndView getEdit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("bookform");
        List<Author> authorList = this.authorService.getAuthorList();
        List<Category> categoryList = this.categoryService.getCategoryList();
        mv.addObject("authorList", authorList);
        mv.addObject("categoryList", categoryList);
        Book book = this.bookService.findById(id);
        mv.addObject("book", book);
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.bookService.delete(id);
        return "redirect:/searchAll";
    }

    @GetMapping("/book/form/add")
    public ModelAndView getFormAdd() {
        ModelAndView mv = new ModelAndView("bookform");
        List<Author> authorList = this.authorService.getAuthorList();
        List<Category> categoryList = this.categoryService.getCategoryList();
        mv.addObject("authorList", authorList);
        mv.addObject("categoryList", categoryList);
        return mv;
    }

    @PostMapping("/book/form/save")
    public String saveBook(@Valid Book book, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            redirect.addFlashAttribute("mensagem", "Erro!");
            return "redirect:/book/form/add";
        }
        this.bookService.save(book);
        return "redirect:/searchAll";
    }
}
