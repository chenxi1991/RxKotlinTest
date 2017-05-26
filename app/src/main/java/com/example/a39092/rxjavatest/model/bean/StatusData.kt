package com.example.a39092.rxjavatest.model.bean

/**
 * Created by 39092 on 2017/4/1.
 */

class StatusData<T> {
    var status: Int = 0
    var info: String? = null
    var data: T? = null

    constructor(status: Int, info: String) {
        this.status = status
        this.info = info
    }

    constructor(status: Int, info: String, data: T) {
        this.status = status
        this.info = info
        this.data = data
    }

}
