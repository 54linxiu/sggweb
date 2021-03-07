package com.qht.pojo;

public class Book {
    String name;
    String author;
    double price;

    public Book(){

    }

    public Book(String name,String autoor,double price){
        this.name = name;
        this.author = autoor;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
