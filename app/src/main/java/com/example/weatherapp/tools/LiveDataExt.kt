package com.sawaf.weatherappex.tools

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this) {
        it?.let {
                 action(it) } }
}

/*fun <T> LifecycleOwner.observeEvent(liveData: LiveData<SingleEvent<T>>, action: (t: SingleEvent<T>) -> Unit) {
    liveData.observe(this) { it?.let { t -> action(t) } }
}

fun <T> LifecycleOwner.observeEventOnce(liveData: LiveData<SingleEvent<T>>, action: (t: T) -> Unit) {
    liveData.observe(this) { it.getContentIfNotHandled()?.also(action) }
}*/

/**
 * Syntactic sugar for [LiveData.observeNotNull] function where the [Observer] is the last parameter.
 * Hence can be passed outside the function parenthesis.
 */
inline fun <T> LiveData<T>.observeNotNull(owner: LifecycleOwner, crossinline observer: (T) -> Unit) {
    this.observe(owner) { it?.apply(observer) }
}

/*
fun <T> MutableLiveData<SingleEvent<T>>.updateValue(data: T, isBackgroundThread: Boolean = false) {
    if (isBackgroundThread)
        postValue(SingleEvent(data))
    else
        this.value = SingleEvent(data)
}*/
