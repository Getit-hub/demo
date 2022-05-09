package com.sww.service;

import com.sww.config.SpringConfig;
import com.sww.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
    @Autowired
    private  BookService bookService;

    @Test
    public  void testGetById(){
        Book book=bookService.getById(3);
        System.out.println(book);
    }
    @Test
    public  void testGetAll(){
        List<Book> list=bookService.getAll();
        System.out.println(list);
    }

    @Test
    public void TestUpdate(){
        Book book=new Book();
        book.setDescription("111");
        book.setName("test");
        book.setType("fdaf");
        book.setId(13);
        bookService.update(book);
    }

    @Test
    public  void TestDelete(){
        //bookService.delete(13);
    }
}
