package io.github.armcha

import android.graphics.Typeface
import android.os.Bundle
import android.text.style.StyleSpan
import android.text.style.TypefaceSpan
import android.text.style.UnderlineSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import io.github.armcha.autolink.*
import kotlinx.android.synthetic.main.activity_static_text.*

class StaticTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_text)
        val custom = MODE_CUSTOM("\\sAndroid\\b", "\\smobile\\b")
        autoLinkTextView.addAutoLinkMode(
            MODE_URL
        )
        val text = "http://mp.weixin.qq.com/s?__biz=MzIzNzA5NjE0Mw==&mid=2653648867&idx=1&sn=af50d0304601c0e71dc3323e1d9ec64d&chksm=f3120a43c4658355ac9c18d86378d699e8275753175af24875e5e1b36af0a16c0ea488419e71#rd"

        autoLinkTextView.addSpan(MODE_URL, StyleSpan(Typeface.ITALIC), UnderlineSpan())
        autoLinkTextView.addSpan(MODE_HASHTAG, UnderlineSpan(), TypefaceSpan("monospace"))
        autoLinkTextView.addSpan(custom, StyleSpan(Typeface.BOLD))

        autoLinkTextView.hashTagModeColor = ContextCompat.getColor(this, R.color.color5)
        autoLinkTextView.phoneModeColor = ContextCompat.getColor(this, R.color.color3)
        autoLinkTextView.customModeColor = ContextCompat.getColor(this, R.color.color1)
        autoLinkTextView.mentionModeColor = ContextCompat.getColor(this, R.color.color6)
        autoLinkTextView.emailModeColor = ContextCompat.getColor(this, R.color.colorPrimary)
        autoLinkTextView.text = text

        autoLinkTextView.onAutoLinkClick {
            val message = if (it.originalText == it.transformedText) it.originalText
            else "Original text - ${it.originalText} \n\nTransformed text - ${it.transformedText}"
            val url = if (it.mode is MODE_URL) it.originalText else null
            showDialog(it.mode.modeName, message, url)
        }
    }
}
