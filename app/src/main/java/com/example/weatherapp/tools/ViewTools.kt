package com.sawaf.weatherappex.tools

import android.app.Service
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.squareup.picasso.Picasso


fun TextView.getInputString( string: String) {
   text=string
}

fun EditText.getInputString(): String {
    return text.toString()
}
fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toGone() {
    visibility = View.GONE
}

fun View.hideKeyboard() {
    (this.context.getSystemService(Service.INPUT_METHOD_SERVICE) as? InputMethodManager)
        ?.hideSoftInputFromWindow(this.windowToken, 0)
}
var baseUrl = "https://openweathermap.org/img/w/"
fun ImageView.loadImage(url: String, placeholder: Int = R.drawable.ic_launcher_background, context :Context) =
    Picasso.with(context)
        .load("$baseUrl$url.png")
        .placeholder(placeholder)
        .error(placeholder)
        .resize(100, 100)
        .onlyScaleDown()
        .centerCrop()
        .into(this)

/**
 * Easy toast function for Activity.
 */
fun Fragment.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, text, duration).show()
}



/**
 * Inflate the layout specified by [layoutRes].
 */
fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}