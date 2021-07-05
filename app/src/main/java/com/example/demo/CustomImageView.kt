package com.example.demo

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 * Created by tanqing.cc
 * on 2021/7/5
 * 要求使用自定义可见行属性
 */

class CustomImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    var vis: Boolean = false
    init {
        attrs?.let {
            context.obtainStyledAttributes(it, R.styleable.customImageview).apply {
                vis= this.getBoolean(R.styleable.customImageview_vis, false)
                recycle()
            }
        }
    }

    override fun setImageResource(resId: Int) {
        if (vis) {
            super.setImageResource(resId)
        }
    }
}