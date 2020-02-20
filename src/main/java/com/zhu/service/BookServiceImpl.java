package com.zhu.service;

import com.zhu.dao.BookMapper;
import com.zhu.pojo.Books;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class BookServiceImpl implements BookService{

//    @Autowired
//    @Qualifier("bookMapper")
    private BookMapper bookMapper;


    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books book) {
        return bookMapper.updateBook(book);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }


    public List<Books> queryAllBook() {
        List<Books> books = bookMapper.queryAllBook();
        return books;
    }

    @Override
    public Books queryBookByName(String name) {
        return bookMapper.queryBookByName(name);
    }
}
