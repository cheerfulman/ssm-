package com.zhu.dao;

import com.zhu.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
//@Repository("BookMapper")
public interface BookMapper {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookID")int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookID")int id);

    //查询所有书
    List<Books> queryAllBook();


    Books queryBookByName(@Param("bookName") String name);
}
