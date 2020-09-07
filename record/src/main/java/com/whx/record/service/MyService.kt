package com.whx.record.service

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

interface MyService : IProvider {
    fun sayHello(msg: String)
}