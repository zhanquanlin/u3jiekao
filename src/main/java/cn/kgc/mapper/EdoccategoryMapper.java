package cn.kgc.mapper;

import cn.kgc.book.Edoccategory;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EdoccategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Edoccategory record);

    int insertSelective(Edoccategory record);

    Edoccategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Edoccategory record);

    int updateByPrimaryKey(Edoccategory record);

    @Select("select * from edoc_category")
    List<Edoccategory> selectBybookca();
}