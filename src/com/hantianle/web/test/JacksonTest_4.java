package com.hantianle.web.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hantianle.web.domain.Person;
import org.junit.Test;

public class JacksonTest_4 {
    /**
     *  演示 json字符串转为Java对象
     */
    @Test
    public void test() throws Exception{
        //1、初始化json字符串
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        //2、创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //3、转为Java对象 --> Person对象
        Person person = mapper.readValue(json, Person.class);

        System.out.println(person); //默认使用Person类里面的toString()方法输出。
    }
}

