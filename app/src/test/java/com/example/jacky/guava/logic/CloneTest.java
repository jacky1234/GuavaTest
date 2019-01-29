package com.example.jacky.guava.logic;

import com.Utils;
import com.example.jacky.guava.module.School;
import com.example.jacky.guava.module.Student;

import org.junit.Test;

public class CloneTest {

    @Test
    public void testClone() {
        Student s1 = new Student("jack", 10, new School("JIAOTONG UNIVERSITY", true));
        Student s2;
        try {
            s2 = (Student) s1.clone();
            Utils.println(s1 + "-" + s1.toString());
            Utils.println(s2 + "-" + s2.toString());
            Utils.println(s1.getName() == s2.getName() ? "String 是final类型---clone是浅拷贝的" : "clone是深拷贝的");
            Utils.println(s1.getSchool() == s2.getSchool() ? "school clone是浅拷贝的" : "school clone是深拷贝的");
            Utils.println(s1.getSchool().isIs211() == s2.getSchool().isIs211() ? "boolean clone是浅拷贝的" : "boolean clone是深拷贝的");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
