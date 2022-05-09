package com.sww.controller;

import com.sww.domain.Book;
import com.sww.exception.SystemException;
import com.sww.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag=bookService.save(book);
        return  new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag,flag?"新增成功":"新增失败");
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag=bookService.update(book);
        return  new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag,flag?"更新成功":"更新失败");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag=bookService.delete(id);
        return  new Result(flag?Code.Delete_OK:Code.Delete_ERR,flag);
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        if(id<1){
            throw new SystemException("id不能小于1，请重试",Code.PROJECT_BUSINESS_ERROR);
        }
        Book book= bookService.getById(id);
        //int i=1/0;
        Integer code= book!=null ?Code.GET_OK:Code.GET_ERR;
        String msg= book!=null ?"":"查询失败，请重试";
        return  new Result(code,book,msg);
    }

    @GetMapping
    public Result getAll() {
        List<Book> list= bookService.getAll();
        Integer code= list!=null ? Code.GET_OK:Code.GET_ERR;
        String msg= list!=null ?"":"查询失败，请重试！";
        return  new Result(code,list,msg);
    }
}
