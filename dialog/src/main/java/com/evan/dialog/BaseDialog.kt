package com.evan.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager


/**
 * Created by Evan on 2018/3/19.
 */
abstract class BaseDialog @JvmOverloads constructor(ctx: Context, private val mGravity:Int = Gravity.BOTTOM,
                                                    theme: Int = R.style.bottom_Dialog, private val anim: Int = R.style.V5_Animation_Dialog) : Dialog(ctx,theme) {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_NO_TITLE)

        if(getLayoutId() != null) {
            setContentView(getLayoutId()!!)
        }
        initView()

        setCanceledOnTouchOutside(true)

        val lp = this.window.attributes
        lp.windowAnimations = anim
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = mGravity
        this.window.attributes = lp

    }

    abstract fun initView()

    abstract fun getLayoutId(): Int?

    override fun show() {
        super.show()
    }

}