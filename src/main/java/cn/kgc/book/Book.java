package cn.kgc.book;

import java.sql.Date;

public class Book {
    private Integer cid;
    private String bookname;
    private String bookzhai;
    private String bookr;
    private Date bookdate;

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookzhai() {
        return bookzhai;
    }

    public void setBookzhai(String bookzhai) {
        this.bookzhai = bookzhai;
    }

    public String getBookr() {
        return bookr;
    }

    public void setBookr(String bookr) {
        this.bookr = bookr;
    }

    public Date getBookdate() {
        return bookdate;
    }

    public void setBookdate(Date bookdate) {
        this.bookdate = bookdate;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
