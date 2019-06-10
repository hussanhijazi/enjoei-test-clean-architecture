package br.com.hussan.enjoeitest.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import br.com.hussan.enjoeitest.domain.Avatar
import br.com.hussan.enjoeitest.domain.Photo
import com.cloudinary.android.MediaManager
import com.squareup.picasso.Picasso


@BindingAdapter("bind:loadImageProduct")
fun loadImageProduct(view: ImageView, photos: List<Photo?>) {
    val imageUrl = photos?.first()?.run {
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
    Picasso.get().load(imageUrl).into(view)
}

@BindingAdapter("bind:loadImageAvatar")
fun loadImageAvatar(view: ImageView, avatar: Avatar) {

    val imageUrl = avatar?.run {
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
