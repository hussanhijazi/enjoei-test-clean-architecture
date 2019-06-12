package br.com.hussan.enjoeitest.ui.productdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import br.com.hussan.enjoeitest.R
import br.com.hussan.enjoeitest.domain.Photo
import br.com.hussan.enjoeitest.extensions.getUrl
import br.com.hussan.enjoeitest.extensions.px
import br.com.hussan.enjoeitest.views.ImageLoadingView
import com.cloudinary.android.MediaManager
import com.squareup.picasso.Picasso

class ImagesAdapter(
    private val mContext: Context,
    private val imageList: List<Photo>
) : PagerAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(mContext)

    @Suppress("UnsafeCast")
    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val imageLayout = inflater.inflate(R.layout.lyt_photo_slider, collection, false) as ViewGroup
        val imgPhoto = imageLayout.findViewById<ImageLoadingView>(R.id.imageSlider)
        val imageUrl = imageList[position].run {
            MediaManager.get().getUrl(
                publicId,
                crop,
                gravity,
                360.px,
                428.px
            )
        }
        Picasso.get().load(imageUrl).fit().noFade().into(imgPhoto.image)
        collection.addView(imageLayout)
        return imageLayout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as? View)
    }

    override fun getCount() = imageList.size

    override fun isViewFromObject(view: View, `object`: Any) = view === `object`

    override fun getPageTitle(position: Int) = imageList[position].toString()

}
