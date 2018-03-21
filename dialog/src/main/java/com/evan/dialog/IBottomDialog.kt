package com.evan.dialog

import android.content.Context
import android.content.DialogInterface
import android.widget.TextView

/**
 * Created by Evan on 2018/3/13.
 */
class IBottomDialog(ctx: Context): BaseDialog(ctx){


    override fun getLayoutId() = R.layout.dialog_bottom


    private var tvTitle: TextView? = null
    private var tvSubtitle: TextView? = null
    private var btnPositive: TextView? = null
    private var btnNegative: TextView? = null
    override fun initView() {
        tvTitle = findViewById(R.id.tv_title)
        tvSubtitle = findViewById(R.id.tv_subtitle)
        btnPositive = findViewById(R.id.btn_positive)
        btnNegative = findViewById(R.id.btn_negative)

        btnPositive?.setOnClickListener {
            mPositiveListener?.onClick(this@IBottomDialog,DialogInterface.BUTTON_POSITIVE)
            dismiss()
        }
        btnNegative?.setOnClickListener {
            mNegativeListener?.onClick(this@IBottomDialog,DialogInterface.BUTTON_NEGATIVE)
            dismiss()
        }
    }

    private var mPositiveListener: DialogInterface.OnClickListener? = null
    private var mNegativeListener: DialogInterface.OnClickListener? = null
    private var mTitleText: CharSequence? = null
    private var mTitleRes: Int? = null
    private var mSubTitleText: CharSequence? = null
    private var mNegative: CharSequence? = null
    private var mPositive: CharSequence? = null

    fun setTitleText(title: CharSequence): IBottomDialog {
        mTitleText = title
        return this
    }

    fun setTitleText(title: Int): IBottomDialog {
        mTitleRes = title
        return this
    }

    fun setSubTitle(subtitle: CharSequence): IBottomDialog {
        mSubTitleText = subtitle
        return this
    }

    fun setNegative(negative: CharSequence,listener: DialogInterface.OnClickListener?): IBottomDialog {
        mNegative = negative
        mNegativeListener = listener
        return this
    }

    fun setPositive(positive: CharSequence, listener: DialogInterface.OnClickListener?): IBottomDialog {
        mPositive = positive
        mPositiveListener = listener
        return this
    }

}