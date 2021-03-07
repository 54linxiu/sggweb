package com.qht.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qht.pojo.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJson {
    @Test
    public void test1(){
        //javaBean转换成为json
        Student student = new Student(1,"linxiu");
        //创建Gson对象
        Gson gson = new Gson();
        //转换为字符串json格式
        String s = gson.toJson(student);
        System.out.println(s);
        //将字符串json 转换为javaBean
        Student student1 = gson.fromJson(s, Student.class);
        System.out.println(student1);
    }
//    List 和 json 的互转
    @Test
    public void test2(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "打完"));
        list.add(new Student(2, "安德森"));

        //创建Gson
        Gson gson = new Gson();
        //将list转换为json
        String s = gson.toJson(list);
        System.out.println(s);
        //将json转换为list数组
        List<Student> o = gson.fromJson(s, new StudentListTypt().getType());
        System.out.println(o.get(0));
    }
    //map 和 json 的互转
    @Test
    public void test3(){
        Map<Integer,Student> map = new HashMap<>();
        map.put(1,new Student(1,"张帅"));
        map.put(2,new Student(2,"安多佛"));

        //创建Gson
        Gson gson = new Gson();
        //map转换为json
        String s = gson.toJson(map);
        System.out.println(s);
        //将jsom转换为map
//        Map<Integer,Student> o = gson.fromJson(s, new StudentMapTypt().getType());
        Map<Integer,Student> o = gson.fromJson(s, new TypeToken<Map<Integer,Student>>(){}.getType());
        System.out.println(o.get(1));
    }
}
