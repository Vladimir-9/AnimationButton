package com.juztoss.animationsdemo.fragments

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import com.juztoss.animationsdemo.R

internal class DDDDD(
    private val maxSize: Float,
    private val maxSpeed: Float,
    private val context: Context
) {

    private var speed: Double = 0.0
    private var offset: Double = 0.0

    fun reset() {
        speed = maxSpeed.toDouble()
    }

    fun update() {
        offset += speed
    }

    fun stopAnim() {
        offset = 0.0
    }

    fun draw(canvas: Canvas?) {
        if (canvas == null) {
            return
        }
        val radius = 18f.dpToPx()
        val radius2 = 20f.dpToPx()

        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.WHITE
        paint.setStrokeWidth(2.5F.dpToPx())
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        val path = Path()

        val center = 34F.dpToPx()

        val startAngelRight = -35F
        val startAngelLeft = 145F

        val oval = RectF()
// правая внешняя дуга
        oval.set(center - radius, center - radius, center + radius, center + radius)
        path.addArc(oval, startAngelRight + offset.toFloat(), 70F)
//        path.addArc(oval, startAngel, 70F)

// левая внешняя дуга
        oval.set(center - radius, center - radius, center + radius, center + radius)
        path.addArc(oval, startAngelLeft + offset.toFloat(), 70F)
//        path.addArc(oval, startAngel2, 70F)

        val offsetInnerArc = 10F.dpToPx()

// правая внутренняя дуга
        oval.set(
            center - radius2 + offsetInnerArc,
            center - radius2 + offsetInnerArc,
            center + radius2 - offsetInnerArc,
            center + radius2 - offsetInnerArc
        )
        path.addArc(oval, (startAngelRight - 10) - offset.toFloat(), 90F)
//        path.addArc(oval, startAngel - 10, 90F)

// левая внутренняя дуга
        oval.set(
            center - radius2 + offsetInnerArc,
            center - radius2 + offsetInnerArc,
            center + radius2 - offsetInnerArc,
            center + radius2 - offsetInnerArc
        )
        path.addArc(oval, (startAngelLeft - 10) - offset.toFloat(), 90F)
//        path.addArc(oval, startAngel2 - 10 , 90F)

//        Log.e("dvsvdsvds", " y $y")

        val p = Paint()
        p.setColor(context.resources.getColor(R.color.darkGrey))
// основной круг
        canvas.drawCircle(center, center, center, p)
// точка в центре круга
        canvas.drawCircle(center, center, 2.5F.dpToPx(), p.apply { setColor(Color.WHITE) })
        canvas.drawPath(path, paint)

    }
}

fun Float.dpToPx(): Float = this * Resources.getSystem().displayMetrics.density