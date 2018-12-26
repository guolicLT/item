package com.guolic.library.emtity;

public class BookVO extends Book {
	private String typeId;
    public String getTypeId() {
        return typeId;
    }
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    public BookVO() {
        super();
        // TODO Auto-generated constructor stub
    }
    public BookVO(String id, String name, String writer, String img, int isBorrowed) {
        super(id, name, writer, img, isBorrowed);
        // TODO Auto-generated constructor stub
    }
   
}
