package com.ashamsi.nbateamviewer.util.view

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import com.ashamsi.nbateamviewer.R
import com.ashamsi.nbateamviewer.databinding.LayoutErrorViewBinding

class ErrorMessageView : FrameLayout {
    @JvmOverloads
    constructor(
            context: Context,
            attrs: AttributeSet? = null,
            defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr)

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
            context: Context,
            attrs: AttributeSet?,
            defStyleAttr: Int,
            defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes)

    private val binding: LayoutErrorViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_error_view, this, true)

    fun setMessage(message: String?) {
        visibility = if (message == null) View.GONE else View.VISIBLE
        binding.txtErrorMessage.text = message
    }
}