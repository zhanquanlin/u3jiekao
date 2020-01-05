package cn.kgc.service;

import cn.kgc.book.Book;
import cn.kgc.book.Edoccategory;
import cn.kgc.book.Edocentry;
import cn.kgc.book.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface Bookservice {
    PageInfo selectBybook(Integer cid, Integer pageNum, Integer pageSize);

    List<Edoccategory> selectBybookca();

    int add(Book book);

    Edocentry selectBybooked(Integer id);

    int update(Book book);

    int delete(Integer id);
}
