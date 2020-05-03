package com.ashamsi.nbateamviewer.util.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.ashamsi.nbateamviewer.R
import com.ashamsi.nbateamviewer.databinding.LayoutCircularProgressViewBinding

class CircularProgressView : ConstraintLayout {
    @JvmOverloads
    constructor(
            context: Context,
            attrs: AttributeSet? = null,
            defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr)

    private val binding: LayoutCircularProgressViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_circular_progress_view, this, true)

}