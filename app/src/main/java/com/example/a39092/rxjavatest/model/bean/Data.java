package com.example.a39092.rxjavatest.model.bean;

import java.util.List;

/**
 * Created by 39092 on 2017/4/1.
 */

public class Data {

    private List<People> list;

    public Data(List<People> list) {
        this.list = list;
    }

    public List<People> getList() {
        return list;
    }

    public void setList(List<People> list) {
        this.list = list;
    }

    public static class People {
        private String name;
        private String age;

        public People(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "People{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
