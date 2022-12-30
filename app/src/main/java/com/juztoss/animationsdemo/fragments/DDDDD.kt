package com.juztoss.animationsdemo.fragments

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.Log
import com.juztoss.animationsdemo.R

internal class DDDDD(
    private val containerWidth: Int,
    private val containerHeight: Int,
    private val maxSize: Float,
    private val maxSpeed: Float,
    private val context: Context
) {

    private var size: Double = 0.0
    private var speed: Double = 0.0
    private var x: Double = 0.0
    private var y: Double = 0.0

    init {
        reset()
    }

    private fun reset() {
        size = Math.random() * maxSize / 2 + maxSize / 2
        speed = Math.random() * maxSpeed / 2 + maxSpeed / 2
        y = -size;
        x = Math.random() * containerWidth
    }

    fun update() {
        y += speed
        if (y > containerHeight) {
            reset()
        }
    }

    fun draw(canvas: Canvas?) {
        if (canvas == null) {
            return
        }
        val radius = 60f

        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.WHITE
        paint.setStrokeWidth(7F)
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        val path = Path()

        val center_x = 120f
        val center_y = 120f

        val startAngel = -35F
        val startAngel2 = 145F

        val offset = y.toFloat()
//        val center_x2 = 160f
//        val center_y2 = 100f

        val oval = RectF()
        oval.set(center_x - radius, center_y - radius, center_x + radius, center_y + radius)
//        path.addArc(oval, startAngel + y.toFloat(), 70F)
        path.addArc(oval, startAngel, 70F)

        oval.set(center_x - radius, center_y - radius, center_x + radius, center_y + radius)
//        path.addArc(oval, startAngel2 + y.toFloat(), 70F)
        path.addArc(oval, startAngel2, 70F)

        val offset_one = 30
        val offset_two = 30

        oval.set(
            center_x - radius + offset_one,
            center_y - radius + offset_one,
            center_x + radius - offset_two,
            center_y + radius - offset_two
        )
//        path.addArc(oval, startAngel - y.toFloat(), 90F)
        path.addArc(oval, startAngel - 10, 90F)

        oval.set(
            center_x - radius + offset_one,
            center_y - radius + offset_one,
            center_x + radius - offset_two,
            center_y + radius - offset_two
        )
//        path.addArc(oval, startAngel2 - y.toFloat(), 90F)
        path.addArc(oval, startAngel2 - 10 , 90F)


//        Log.e("dvsvdsvds", " y $y")



        val p = Paint()
        p.setColor(context.resources.getColor(R.color.darkGrey))
        canvas.drawCircle(center_x, center_y, 120F, p)
        canvas.drawCircle(center_x, center_y, 8F, p.apply { setColor(Color.WHITE) })
        canvas.drawPath(path, paint)

    }
}
