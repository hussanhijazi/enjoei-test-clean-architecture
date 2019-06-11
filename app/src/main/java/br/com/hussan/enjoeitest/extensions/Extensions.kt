package br.com.hussan.enjoeitest.extensions

import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.core.app.ActivityOptionsCompat
import com.google.android.material.snackbar.Snackbar
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun View.snack(@StringRes messageRes: Int, length: Int = Snackbar.LENGTH_LONG) {
    snack(resources.getString(messageRes), length)
}

fun View.snack(
    message: String,
    length: Int = Snackbar.LENGTH_LONG
) {
    val snack = Snackbar.make(this, message, length)
    snack.show()
}

fun Snackbar.action(@StringRes actionRes: Int, color: Int? = null, listener: (View) -> Unit) {
    action(view.resources.getString(actionRes), color, listener)
}

fun Snackbar.action(action: String, color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Disposable.add(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

inline fun <reified T : Activity> Activity.navigate(
    bundle: Bundle? = null,
    options: ActivityOptionsCompat? = null
) {
    val intent = Intent(this, T::class.java)
    intent.apply {
        bundle?.let { putExtras(bundle) }
        startActivity(this, options?.toBundle())
    }
}

inline fun <reified T : Activity> Activity.navigateForResult(
    codeRequest: Int,
    bundle: Bundle? = null
) {
    val intent = Intent(this, T::class.java)
    intent.apply {
        bundle?.let { putExtras(bundle) }
        startActivityForResult(this, codeRequest)
    }
}
