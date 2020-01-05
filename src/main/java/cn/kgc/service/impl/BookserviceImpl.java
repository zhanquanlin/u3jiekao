package cn.kgc.service.impl;

import cn.kgc.book.Book;
import cn.kgc.book.Edoccategory;
import cn.kgc.book.Edocentry;
import cn.kgc.book.User;
import cn.kgc.mapper.EdoccategoryMapper;
import cn.kgc.mapper.EdocentryMapper;
import cn.kgc.service.Bookservice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookserviceImpl implements Bookservice {
    @Autowired
    EdocentryMapper edocentryMapper;

    @Autowired
    EdoccategoryMapper edoccategoryMapper;
    @Override
    public PageInfo selectBybook(Integer cid, Integer pageNum, Integer pageSize) {
        System.out.println(cid+"==>"+pageNum+"==>"+pageSize);
        PageHelper.startPage(pageNum,pageSize);
        System.out.println("zzz");
        User user=new User();
        user.setCid(cid);
        List<Edocentry> edocentries = edocentryMapper.selectBybook(user);
        PageInfo pageInfo=new PageInfo(edocentries);
        return pageInfo;
    }

    @Override
    public List<Edoccategory> selectBybookca() {
        List<Edoccategory> edoccategories = edoccategoryMapper.selectBybookca();
        return edoccategories;
    }

    @Override
    public int add(Book book) {
        int add = edocentryMapper.add(book);
        return add;
    }

    @Override
    public Edocentry selectBybooked(Integer id) {
        Edocentry edocentry = edocentryMapper.selectBybooked(id);
        return edocentry;
    }

    @Override
    public int update(Book book) {
        int update = edocentryMapper.update(book);
        return update;
    }

    @Override
    public int delete(Integer id) {
        int delete = edocentryMapper.delete(id);
        return delete;
    }


}
