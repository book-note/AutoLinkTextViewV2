package io.github.armcha.autolink

import android.widget.TextView

fun TextView.notConsumeTouchEvent(){
    this.isClickable = false
    this.isLongClickable = false
    this.isFocusable = false
}

fun TextView.consumeTouchEvent(){
    this.isClickable = true
    this.isLongClickable = true
    this.isFocusable = true
}