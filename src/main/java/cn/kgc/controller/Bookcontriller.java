package cn.kgc.controller;

import cn.kgc.book.Book;
import cn.kgc.book.Edoccategory;
import cn.kgc.book.Edocentry;
import cn.kgc.service.Bookservice;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class Bookcontriller {
    @Autowired
    Bookservice bookservice;

    @RequestMapping("/list")
    public ModelAndView demo(@RequestParam(value = "cId",defaultValue = "0") String cid,@RequestParam(defaultValue = "1",value = "p")String pageNum, ModelAndView modelAndView){
        Integer integer=new Integer(cid);
        int cid1=integer;
        Integer integer1=new Integer(pageNum);
        PageInfo pageInfo = bookservice.selectBybook(cid1, integer1, 2);
        System.out.println("admin");
        List<Edoccategory> edoccategories = bookservice.selectBybookca();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("edoccategories",edoccategories);
        modelAndView.addObject("cid",cid);
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @RequestMapping("/add")
    public ModelAndView demo1(@RequestParam(value = "bookname")String bookname,@RequestParam(value = "bookzhai")String bookzhai,@RequestParam(value = "bookr")String bookr,@RequestParam(value = "bookdate")String bookdate,
    ModelAndView ModelAndView,@RequestParam(value = "cId")String cid) throws ParseException {
        Integer cid1=new Integer(cid);
        Book book=new Book();
        book.setCid(cid1);
        book.setBookname(bookname);
        book.setBookzhai(bookzhai);
        book.setBookr(bookr);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(bookdate);
        java.sql.Date date=new java.sql.Date(parse.getTime());
        book.setBookdate(date);
        int add = bookservice.add(book);
        ModelAndView.setViewName("forward:list");
        return ModelAndView;
    }

    @RequestMapping("/add1")
    public ModelAndView demo2(ModelAndView modelAndView){
        List<Edoccategory> edoccategories = bookservice.selectBybookca();
        modelAndView.addObject("edoccategories",edoccategories);
        modelAndView.setViewName("add");
        return modelAndView;
    }


    @RequestMapping("/update")
    public ModelAndView update(@Param("id")String id,ModelAndView modelAndView){
        Integer id1=new Integer(id);
        Edocentry edocentry = bookservice.selectBybooked(id1);
        modelAndView.addObject("edocentry",edocentry);
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @RequestMapping("/update2")
    public ModelAndView update1(ModelAndView modelAndView,@RequestParam(value = "bookid")String id,@RequestParam(value = "bookname")String bookname,@RequestParam(value = "bookzhai")String bookzhai,@RequestParam(value ="shangchuanr")String shangchuanr,@RequestParam(value = "shangchuanshi")String shangchuanshi) throws ParseException {
        Book book=new Book();
        System.out.println(shangchuanshi);
        if(shangchuanshi==null||shangchuanshi.equals("")){
            Date date=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            shangchuanshi= simpleDateFormat.format(date);
        }

        System.out.println(id);
        Integer id1=new Integer(id);
        book.setCid(id1);
        book.setBookname(bookname);
        book.setBookzhai(bookzhai);
        book.setBookr(shangchuanr);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(shangchuanshi);
        java.sql.Date date=new java.sql.Date(parse.getTime());
        book.setBookdate(date);
        int update = bookservice.update(book);
        if(update>0){
            modelAndView.addObject("update","success");
        }else{
            modelAndView.addObject("update","fail");
        }
        modelAndView.setViewName("forward:list");
        return modelAndView;
    }

    @RequestMapping("/del")
    public ModelAndView delete(ModelAndView modelAndView,@RequestParam(value = "id")String id){
        Integer integer=new Integer(id);
        int delete = bookservice.delete(integer);
        if(delete>0){
            modelAndView.addObject("del","success");
        }else{
            modelAndView.addObject("del","fail");
        }
        modelAndView.setViewName("forward:list");
        return modelAndView;
    }
}
