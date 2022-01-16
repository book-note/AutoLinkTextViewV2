package io.github.armcha.autolink

import android.graphics.Color
import android.text.TextPaint
import android.text.style.ClickableSpan

internal abstract class TouchableSpan(private val normalTextColor: Int) : ClickableSpan() {

    override fun updateDrawState(textPaint: TextPaint) {
        super.updateDrawState(textPaint)
        val textColor = normalTextColor
        with(textPaint) {
            isAntiAlias = true
            color = textColor
            isUnderlineText = false
            bgColor = Color.TRANSPARENT
        }
    }
}