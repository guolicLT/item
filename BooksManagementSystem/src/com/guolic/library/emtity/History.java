package com.guolic.library.emtity;

public class History {
    private String id;
    private String bid;
    private String uid;
    private String borrow_time;
    private String return_time;
    public History() {
    }
    public History(String id, String bid, String uid, String borrow_time, String return_time) {
        super();
        this.id = id;
        this.bid = bid;
        this.uid = uid;
        this.borrow_time = borrow_time;
        this.return_time = return_time;
    }
    public History(String id, String bid, String uid, String borrow_time) {
        super();
        this.id = id;
        this.bid = bid;
        this.uid = uid;
        this.borrow_time = borrow_time;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getBid() {
        return bid;
    }
    public void setBid(String bid) {
        this.bid = bid;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getBorrow_time() {
        return borrow_time;
    }
    public void setBorrow_time(String borrow_time) {
        this.borrow_time = borrow_time;
    }
    public String getReturn_time() {
        return return_time;
    }
    public void setReturn_time(String return_time) {
        this.return_time = return_time;
    }
    @Override
    public String toString() {
        return "History [id=" + id + ", bid=" + bid + ", uid=" + uid + ", borrow_time=" + borrow_time + ", return_time="
                + return_time + "]";
    }

}
