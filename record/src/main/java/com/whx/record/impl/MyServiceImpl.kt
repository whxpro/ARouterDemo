package com.whx.record.impl

import android.content.Context
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.whx.record.service.MyService

@Route(path = "/record/myservice", name = "测试服务")
class MyServiceImpl : MyService {

    private var mContext: Context? = null

    override fun sayHello(msg: String) {
        mContext?.let { Toast.makeText(it, msg, Toast.LENGTH_SHORT).show() }
    }

    override fun init(context: Context?) {
        mContext = context
    }
}