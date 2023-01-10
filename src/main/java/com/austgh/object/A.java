package com.austgh.object;

import org.springframework.stereotype.Component;

public class A {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                '}';
    }
}
