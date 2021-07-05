package com.example.demo

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView

/**
 * Created by tanqing.cc
 * on 2021/7/5
 */

class CustomNavigationBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var leftDrawable: CustomImageView? = null
    private var rightDrawable: CustomImageView? = null
    private var title: TextView? = null

    init {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.custom_navigation_bar_layout, this, true)
        leftDrawable = view.findViewById(R.id.iv_left)
        rightDrawable = view.findViewById(R.id.iv_right)
        title = view.findViewById(R.id.tv_title)

        leftDrawable?.let {
            it.setImageResource(R.drawable.fanhui)
        }
        rightDrawable?.let {
            it.setImageResource(R.drawable.caidan)
        }
    }


    fun setMenuClickAction(action: () -> Unit) {
        rightDrawable?.let {
            if (it.vis) {
                it.setOnClickListener {
                    action.invoke()
                }
            }
        }
    }

}