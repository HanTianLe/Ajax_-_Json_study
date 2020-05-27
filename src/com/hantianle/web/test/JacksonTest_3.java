package com.hantianle.web.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hantianle.web.domain.Person;
import org.junit.Test;

import java.util.*;

public class JacksonTest_3 {
    @Test
    public void test() throws Exception {
        //1、创建Person对象
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(21);
        p1.setGender("女");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("李四");
        p2.setAge(22);
        p2.setGender("女");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setName("王五");
        p3.setAge(23);
        p3.setGender("男");
        p3.setBirthday(new Date());

        //创建List集合
        List<Person> ps = new ArrayList<Person>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);

        //2、转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ps);
        System.out.println(json);
        // [{"name":"张三","age":21,"gender":"女","birthday":"2020-05-04"},
        // {"name":"李四","age":22,"gender":"女","birthday":"2020-05-04"},
        // {"name":"王五","age":23,"gender":"男","birthday":"2020-05-04"}]
    }

    @Test
    public void test2() throws Exception{
        //1、创建map对象
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","张三");
        map.put("age",20);
        map.put("gender","男");
        //2、转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }
}

