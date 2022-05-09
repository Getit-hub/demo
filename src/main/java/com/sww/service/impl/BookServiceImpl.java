package com.sww.service.impl;

import com.sww.dao.BookDao;
import com.sww.domain.Book;
import com.sww.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean save(Book book) {
        return bookDao.save(book)>0;

    }

    @Override
    public boolean update(Book book) {
       return bookDao.update(book) >0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.delete(id) >0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
