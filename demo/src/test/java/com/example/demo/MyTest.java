package com.example.demo;

import com.example.pojo.User;
import org.junit.jupiter.api.Test;

public class MyTest {

   @Test
    public void test1(){
       User user = new User();
       user.setId(1);
       System.out.println(user.toString());
   }
}
