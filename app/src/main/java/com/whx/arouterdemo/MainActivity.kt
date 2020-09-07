package com.whx.arouterdemo

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.whx.basecomponent.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jump.setOnClickListener {
            ARouter.getInstance().build("/record/photo1")
                .withString("photoUrl", "hhh, what the fuck!!!")
                .navigation(this)
        }
    }
}
