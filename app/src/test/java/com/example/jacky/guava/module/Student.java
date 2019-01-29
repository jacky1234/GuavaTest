package com.example.jacky.guava.module;

public class Student implements Cloneable {
    private String name;
    private int age;
    private School school;

    public Student(String name, int age, School school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public School getSchool() {
        return school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student result = (Student) super.clone();
        result.name = String.valueOf(name);
        result.school = (School) school.clone();
        return result;
    }
}
