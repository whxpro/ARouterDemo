package com.whx.basesdk.arouter

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.DegradeService

@Route(path = "/xxx/xxx")
class DegradeServiceImpl : DegradeService {
    private val TAG = "DegradeServiceImpl"

    override fun onLost(context: Context?, postcard: Postcard?) {
        Toast.makeText(context?.applicationContext, "there is no such activity", Toast.LENGTH_SHORT).show()
    }

    override fun init(context: Context?) {
        Log.e(TAG, "degrade service init")
    }
}