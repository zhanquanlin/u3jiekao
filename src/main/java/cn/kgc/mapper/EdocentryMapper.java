package cn.kgc.mapper;

import cn.kgc.book.Book;
import cn.kgc.book.Edocentry;
import cn.kgc.book.User;

import java.util.List;

public interface EdocentryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Edocentry record);

    int insertSelective(Edocentry record);

    Edocentry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Edocentry record);

    int updateByPrimaryKey(Edocentry record);

    List<Edocentry> selectBybook(User user);

    int add(Book book);

    Edocentry selectBybooked(Integer id);

    int update(Book book);

    int delete(Integer id);
}