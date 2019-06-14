package br.com.hussan.enjoeitest.extensions

import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.core.app.ActivityOptionsCompat
import com.cloudinary.android.MediaManager
import com.google.android.material.snackbar.Snackbar
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Double.formatPrice() = String.format("%.2f", this)

fun MediaManager.getUrl(publicId: String, crop: String, gravity: String, width: Int, height: Int) =
    MediaManager.get().url().secure(true).run {
        transformation(
            transformation()
                .crop(crop)
                .gravity(gravity)
                .width(width)
                .height(height)
        ).generate("$publicId.jpg")
    }

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
