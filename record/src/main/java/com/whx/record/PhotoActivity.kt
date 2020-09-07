package com.whx.record

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.whx.basecomponent.BaseActivity
import kotlinx.android.synthetic.main.layout_photo_activity.*

@Route(path = "/record/photo")
class PhotoActivity : BaseActivity() {

    @JvmField
    @Autowired
    var photoUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        setContentView(R.layout.layout_photo_activity)

        text.text = photoUrl
    }
}