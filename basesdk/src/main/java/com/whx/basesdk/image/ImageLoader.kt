package com.whx.basesdk.image

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

object ImageLoader {

    fun load(
        resource: Any?,
        target: ImageView, @DrawableRes placeHolder: Int = 0,
        listener: RequestListener<Drawable>? = null,
        transformation: BitmapTransformation? = null,
        diskCacheStrategy: DiskCacheStrategy? = null,
        decodeFormat: DecodeFormat? = null,
        thumbSize: Float = 0f
    ): Target<Drawable>? {
        val act = getActivityFromView(target.context)
        if (isActivityValid(act)) return null

        val requestBuilder = Glide.with(act!!).load(resource)
        val options = RequestOptions()
        options.transformations = transformation

        return requestBuilder
            .apply(options)
            .addListener(listener)
            .thumbnail(thumbSize)
            .transition(transformation)
            .placeholder(placeHolder)
            .into(target)
    }

    private fun isActivityValid(activity: Activity?): Boolean {
        return activity != null && !activity.isFinishing && !activity.isDestroyed
    }

    private fun getActivityFromView(context: Context?): Activity? {
        if (context == null) return null

        return when (context) {
            is Activity -> context
            is ContextWrapper -> getActivityFromView(context.baseContext)
            else -> null
        }
    }
}