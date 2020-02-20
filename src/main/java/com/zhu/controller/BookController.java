package com.zhu.controller;

import com.zhu.pojo.Books;
import com.zhu.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookServiceImpl bookService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Books> books = bookService.queryAllBook();

        model.addAttribute("list",books);
        return "allBook";
    }
    @RequestMapping("/toAddBook")
    public String addBook(Model model){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addpaper(Books books){
        bookService.addBook(books);
        return "redirect:/book/list";
    }

    @RequestMapping("del/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/list";
    }

    @RequestMapping("/toUpdateBook/{bookID}")
    public String toUpdateBook(@PathVariable("bookID")int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("book",books);
        return "update";
    }

    @RequestMapping("/upSeccessed")
    public String toUpdateBook1(Books books){
        bookService.updateBook(books);
        return "redirect:/book/list";
    }

    @RequestMapping("/query")
    public String queryB(String queryName,Model model){

        System.out.println(queryName);
        Books books = bookService.queryBookByName(queryName);
        List<Books> list = new ArrayList<>();
        list.add(books);
        model.addAttribute("list",list);
        return "allBook";
    }
}
