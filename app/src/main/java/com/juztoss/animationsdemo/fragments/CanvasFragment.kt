package com.juztoss.animationsdemo.fragments

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Fragment
import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.widget.Button
import com.juztoss.animationsdemo.R


class CanvasFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.canvas, container, false);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dddd =view?.findViewById<SnowAnimation>(R.id.snowAnimation)
        val roundButton = view?.findViewById<FloatingActionButton>(R.id.FloatingActionButton)
        val roundButton2 = view?.findViewById<FloatingActionButton>(R.id.FloatingActionButton2)

        view?.findViewById<Button>(R.id.button)?.setOnClickListener {
            dddd?.needAnim = true
            dddd?.dddd()
            dddd?.invalidate()
        }

        view?.findViewById<Button>(R.id.button2)?.setOnClickListener {
//            dddd?.stopAnim()
//            dddd?.needAnim = false


//            ValueAnimator.ofInt()

            roundButton?.scaleX

            dcs(roundButton!!, roundButton2!!)
        }


//        ffff()
//        sssss(roundButton, roundButton?.context!!)
    }
}

 fun sssss(view:FloatingActionButton? , context: Context){
     val actionUp = AnimationUtils.loadAnimation(context, R.anim.action_up)



     view?.startAnimation(actionUp)
 }

fun dcs(view: FloatingActionButton, view2: FloatingActionButton) {
    val one = ViewAnimationUtils.createCircularReveal(
        view,
        (100F.dpToPx() / 2).toInt(),
        (100F.dpToPx() / 2).toInt(),
        0F,
        100F.dpToPx()
    )

    val two = ViewAnimationUtils.createCircularReveal(
        view2,
        (100F.dpToPx() / 2).toInt(),
        (100F.dpToPx() / 2).toInt(),
        0F,
        100F.dpToPx()
    )

    one.addListener(
        object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {
                view.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(p0: Animator?) {
                view.visibility = View.GONE
                one.end()
                two.start()
                Log.e("dvsvdsvds", " onAnimationEnd ")
            }
            override fun onAnimationCancel(p0: Animator?) {
                Log.e("dvsvdsvds", " onAnimationCancel ")
            }
            override fun onAnimationRepeat(p0: Animator?) {}
        }
    )
    one.duration = 800
    one.interpolator = LinearInterpolator()
    one.start()

    two.addListener(
        object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {
                view2.visibility = View.VISIBLE
                Log.e("dvsvdsvds", " two Start")
            }

            override fun onAnimationEnd(p0: Animator?) {
                view2.visibility = View.GONE
                Log.e("dvsvdsvds", " two End   ${one.isStarted}"  )
                two.end()
//                one.start()
            }
            override fun onAnimationCancel(p0: Animator?) {}
            override fun onAnimationRepeat(p0: Animator?) {}
        }
    )
    two.duration = 800
    two.interpolator = LinearInterpolator()

}

fun ffff(view: FloatingActionButton?) {
    val animator = ObjectAnimator.ofFloat(view, "scaleX", 1f, 2.5f)
    animator.duration = 2000
    animator.repeatCount = ValueAnimator.INFINITE


    animator.interpolator = LinearInterpolator()
    animator.start()
}

class SnowAnimation : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    private lateinit var snowflakes: DDDDD
    var needAnim = false

    fun dddd() {
        snowflakes.reset()
    }

    fun stopAnim() {
        snowflakes.stopAnim()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        snowflakes = DDDDD(
            maxSize = resources.getDimension(R.dimen.max_snowflake_size),
            maxSpeed = resources.getDimension(R.dimen.max_snowflake_speed),
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