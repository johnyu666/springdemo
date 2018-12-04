package cn.johnyu.dao;


import cn.johnyu.pojo.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);
    public List<Book> findAllBooks();
}
