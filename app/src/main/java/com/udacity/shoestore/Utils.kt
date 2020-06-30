package com.udacity.shoestore

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import java.lang.NumberFormatException

@BindingAdapter("app:value")
fun setDouble(textView: TextView,double: Double) {
    if (double.isNaN()){
        textView.text = ""
    } else {
        textView.text = "$double"
    }

}

@InverseBindingAdapter(attribute = "android:text")
fun getDouble(view: TextView):Double{
    val string = view.text.toString()
    if (string.isEmpty()) return 0.0
    try {
        return string.toDouble()
    }catch (nfE:NumberFormatException) {
        return 0.0
    }
}