package com.tupurp.learn.springboot.demo.model;

import java.io.Serializable;
/**
 *
 * mybatis测试
* */
public class Department  implements Serializable {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
