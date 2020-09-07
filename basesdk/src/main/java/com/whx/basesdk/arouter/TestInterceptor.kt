package com.whx.basesdk.arouter

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

@Interceptor(priority = 8, name = "测试拦截器")
class TestInterceptor : IInterceptor {

    private val TAG = "TestInterceptor"

    override fun init(context: Context?) {
        Log.e(TAG, "interceptor init")
    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        Log.e(TAG, "interceptor working")

        callback?.onContinue(postcard)
    }
}