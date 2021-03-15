package com.example.mygesture

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MotionEventCompat
import timber.log.Timber
import java.util.jar.Attributes


class MainActivity : AppCompatActivity() {

    private var mgListener: MyGestureListener? = null
    private var mDetector: GestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        mgListener = MyGestureListener("這是Activity發送")
        mDetector = GestureDetector(this,mgListener)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        Timber.d("demo,MainActivity-----------onTouchEvent------  ${event.toString()}")
        mDetector!!.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        Timber.d("demo,MainActivity-----------dispatchTouchEvent--${ev.toString()}")
        return super.dispatchTouchEvent(ev)
    }
}

class SimpleGestureListener(info: String) : GestureDetector.SimpleOnGestureListener() {
    val context = info
    override fun onDown(e: MotionEvent?): Boolean {
        return true
//        return super.onDown(e)
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return true
//        return super.onSingleTapUp(e)
    }

}

class MyGestureListener(info: String) : GestureDetector.OnGestureListener {
    val context = info
    override fun onDown(e: MotionEvent?): Boolean {
        Timber.d("onDown ,${context}")

        return false
//        return true
    }

    override fun onShowPress(e: MotionEvent?) {
        Timber.d("onShowPress, $context")
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        Timber.d("onSingleTapUp, ${context}")
        return false
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        Timber.d("onScroll")
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
        Timber.d("onLongPress, ${context}")
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        Timber.d("onFling")
        return false
    }

}

class Mygroupview(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    private var linemgListener: MyGestureListener? = null
    private var linemDetector: GestureDetector? = null
    init {
        linemgListener = MyGestureListener("這是LinearLayout發送")
        linemDetector = GestureDetector(context,linemgListener)
    }
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
//        Timber.d("demo,LinearLayout--------onInterceptTouchEvent---${ev.toString()}")
//        linemDetector!!.onTouchEvent(ev)
//        return true
        return super.onInterceptTouchEvent(ev)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        Timber.d("demo,LinearLayout---------onTouchEvent-----------${event.toString()}")
        linemDetector!!.onTouchEvent(event)
        return true
//        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        Timber.d("demo,LinearLayout------------dispatchTouchEvent--${ev.toString()}")
        return super.dispatchTouchEvent(ev)
    }
}

class Mytext(context: Context, attrs: AttributeSet) :
    androidx.appcompat.widget.AppCompatTextView(context, attrs) {
    private var textmgListener: MyGestureListener? = null
    private var textmDetector: GestureDetector? = null
    init {
        textmgListener = MyGestureListener("這是Text發送")
        textmDetector = GestureDetector(context,textmgListener)
    }
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        Timber.d("     demo,mytext------------onTouchEvent------------  ${event.toString()}")
        textmDetector!!.onTouchEvent(event)
        return true
//        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
//        Timber.d("     demo,mytext------------dispatchTouchEvent------  ${event.toString()}")
        return super.dispatchTouchEvent(event)
    }

}