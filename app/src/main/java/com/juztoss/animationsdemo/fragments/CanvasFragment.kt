package com.juztoss.animationsdemo.fragments

import android.app.Fragment
import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.juztoss.animationsdemo.R


class CanvasFragment : Fragment {

    constructor() : super()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.canvas, container, false);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dddd =view?.findViewById<SnowAnimation>(R.id.snowAnimation)

        view?.findViewById<Button>(R.id.button)?.setOnClickListener {
            dddd?.needAnim = true
            dddd?.invalidate()
        }

        view?.findViewById<Button>(R.id.button2)?.setOnClickListener {
            dddd?.needAnim = false
        }
    }
}

class SnowAnimation : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private lateinit var snowflakes: DDDDD
    var needAnim = false

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        snowflakes = DDDDD(
            right - left, bottom - top,
            resources.getDimension(R.dimen.max_snowflake_size),
            resources.getDimension(R.dimen.max_snowflake_speed),
            context
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        snowflakes.draw(canvas)

        if (needAnim) {
            snowflakes.apply {
                update()
                draw(canvas)
            }
            postInvalidateOnAnimation()
        }
    }
}