package com.guolic.library.emtity;
/*
 * POJO类
 */
public class Book {
	private String id;
	private String name;
	private String writer;
	private String img;
	private int isBorrowed = 0;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public int getIsBorrowed() {
        return isBorrowed;
    }
    public void setIsBorrowed(int isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
    public Book(String id, String name, String writer, String img, int isBorrowed) {
        super();
        this.id = id;
        this.name = name;
        this.writer = writer;
        this.img = img;
        this.isBorrowed = isBorrowed;
    }
    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	

}
