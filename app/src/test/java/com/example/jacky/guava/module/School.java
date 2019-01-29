package com.example.jacky.guava.module;

public class School implements Cloneable {
    private String name;
    private boolean is211;

    public School(String name, boolean is211) {
        this.name = name;
        this.is211 = is211;
    }

    public String getName() {
        return name;
    }

    public boolean isIs211() {
        return is211;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", is211=" + is211 +
                '}';
    }
}
