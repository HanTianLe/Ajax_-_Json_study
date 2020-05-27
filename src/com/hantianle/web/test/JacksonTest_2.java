package com.hantianle.web.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hantianle.web.domain.Person;
import org.junit.Test;

import java.util.Date;

public class JacksonTest_2 {
    @Test
    public void test() throws Exception {
        //创建Person对象
        Person p = new Person();
        p.setName("李四");
        p.setAge(22);
        p.setGender("女");
        p.setBirthday(new Date());

        //2、转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
        //默认格式：{"name":"李四","age":22,"gender":"女","birthday":1588593440231}
        //当birthday属性添加 @JsonIgnore 注释后，显示：{"name":"李四","age":22,"gender":"女"}
        //当birthday属性添加 @JsonFormat 注释后，
        // 显示：{"name":"李四","age":22,"gender":"女","birthday":"2020-05-04"}
    }
}

