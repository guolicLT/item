package com.guolic.library.emtity;

public class Type {
    private String id;
    private String type;
    private String img;
    public Type() {
        // TODO Auto-generated constructor stub
    }
    
    public Type(String id, String type,String img) {
        super();
        this.id = id;
        this.type = type;
        this.img = img;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Type [id=" + id + ", type=" + type + ", img=" + img + "]";
    }
    
}
