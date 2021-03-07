package com.qht.pojo;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class DomTest {

    @Test
    public void test1(){
        //获取sax解析器对象
        SAXReader sr = new SAXReader();
        //获取文件的Document对象

        try {
            Document doc = sr.read("src/book.xml");
            System.out.println(doc);
        } catch (Exception e){

        }

    }

    @Test
    public void test2(){
        SAXReader sr = new SAXReader();

        try {
            Document doc = sr.read("src/book.xml");

            //获取根元素

            Element root = doc.getRootElement();
            //获取元素名字
//            System.out.println(root.getName());
            //获取内容
//            System.out.println(root.getText());
//            System.out.println(root);

            //获取根元素下的元素
//            Element name = root.element("book");

            List<Element> bookList = root.elements("book");
//            bookList.forEach(e-> System.out.println(e.element("name").getText()));
            for(Element e : bookList){
                Book book = new Book(e.element("name").getText(),e.element("author").getText(),Double.parseDouble(e.element("price").getText()));
                System.out.println(book);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
