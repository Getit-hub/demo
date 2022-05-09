package com.sww.service;

import com.sww.dao.BookDao;
import com.sww.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {

    /**
     * 保存
     * @return
     */
    public  boolean save(Book book);

    /**
     * 更新
     * @param book
     * @return
     */
    public boolean update(Book book);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean  delete(Integer id);

    public  Book getById(Integer id);

    public List<Book> getAll();
}
