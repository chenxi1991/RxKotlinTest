package com.example.a39092.rxjavatest.model.bean

/**
 * Created by 39092 on 2017/4/1.
 */

class Data(var list: List<Data.People>?) {

    class People(var name: String?, var age: String?) {

        override fun toString(): String {
            return "People{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}'
        }
    }
}
