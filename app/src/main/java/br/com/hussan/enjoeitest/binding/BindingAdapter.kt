package br.com.hussan.enjoeitest.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import br.com.hussan.enjoeitest.R
import br.com.hussan.enjoeitest.data.model.ProductView
import br.com.hussan.enjoeitest.domain.Avatar
import br.com.hussan.enjoeitest.domain.Photo
import br.com.hussan.enjoeitest.extensions.formatPrice
import br.com.hussan.enjoeitest.extensions.hide
import br.com.hussan.enjoeitest.views.ImageLoadingView
import com.cloudinary.android.MediaManager
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


@BindingAdapter("bind:imageLoadingProduct")
fun imageLoadingProduct(view: ImageLoadingView, photos: List<Photo?>) {
    view.post {
        val imageUrl = photos.first()?.run {
            MediaManager.get().url().secure(true).run {
                transformation(
                    transformation()
                        .crop(crop)
                        .gravity(gravity)
                        .width(view.measuredWidth)
                        .height(view.measuredHeight)
                ).generate("$publicId.jpg")
            }
        }

        Picasso.get().load(imageUrl).into(
            view.image, object : Callback {
                override fun onSuccess() {
                    view.progressBar.hide()
                }

                override fun onError(e: Exception?) {
                    view.progressBar.hide()
                }
            }
        )
    }
}

@BindingAdapter("bind:showDiscountProduct")
fun showDiscountProduct(view: TextView, product: ProductView) {
    val showDiscount = product.discountPercentage > 0
    view.text = if (showDiscount) {
        "${product.discountPercentage}% off em até ${product.maximumInstallment}x"
    } else {
        "em até ${product.maximumInstallment}x"
    }

}

@BindingAdapter("bind:formatPrice")
fun formatPrice(view: TextView, price: Double) {
    view.text = view.context.getString(R.string.price_format, price.formatPrice())
}

@BindingAdapter("bind:loadImageAvatar")
fun loadImageAvatar(view: ImageView, avatar: Avatar) {

    val imageUrl = avatar.run {
        MediaManager.get().url().secure(true).run {
            transformation(
                transformation()
                    .crop(crop)
                    .gravity(gravity)
                    .width(view.measuredWidth)
                    .height(view.measuredHeight).radius("max")
            ).generate("$publicId.jpg")
        }
    }
    Picasso.get().load(imageUrl).into(view)
}
