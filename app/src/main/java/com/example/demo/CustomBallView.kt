package com.example.demo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Created by tanqing.cc
 * on 2021/7/5
 */

class CustomBallView @JvmOverloads constructor(
    context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        color = Color.RED
        isAntiAlias = true
        style = Paint.Style.FILL
    }

    private var curX = -1f
    private var curY = -1f

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        curX = width * 0.5f
        curY = height * 0.5f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (curX >=0 && curY >= 0) {
            canvas?.drawCircle(curX, curY, 50f, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            curX = it.x
            curY = it.y
            postInvalidate()
        }
        return true
    }

}