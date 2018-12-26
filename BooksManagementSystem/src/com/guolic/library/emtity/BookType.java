package com.guolic.library.emtity;

public class BookType {
    private String bid;
    private String tid;
    public BookType() {
        // TODO Auto-generated constructor stub
    }
    public String getBid() {
        return bid;
    }
    public void setBid(String bid) {
        this.bid = bid;
    }
    public String getTid() {
        return tid;
    }
    public void setTid(String tid) {
        this.tid = tid;
    }
    public BookType(String bid, String tid) {
        super();
        this.bid = bid;
        this.tid = tid;
    }

}
