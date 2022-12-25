package com.sawaf.weatherappex.tools

import android.util.Patterns

fun String?.valid(minChar: Int = 0) : Boolean =
    this != null && !this.equals("null", true)
            && this.trim().isNotEmpty() && this.length >= minChar

//Email Validation mohamed@fdfgf.com
fun String.isValidEmail(): Boolean
        = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

