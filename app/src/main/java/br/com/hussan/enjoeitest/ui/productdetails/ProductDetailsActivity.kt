package br.com.hussan.enjoeitest.ui.productdetails

import android.content.Intent
import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.hussan.enjoeitest.AppNavigator
import br.com.hussan.enjoeitest.AppNavigator.Companion.EXTRA_IMAGE_TRANSITION_NAME
import br.com.hussan.enjoeitest.R
import br.com.hussan.enjoeitest.databinding.ActivityProductBinding
import br.com.hussan.enjoeitest.domain.Product
import br.com.hussan.enjoeitest.extensions.getUrl
import br.com.hussan.enjoeitest.extensions.loadTransition
import com.cloudinary.android.MediaManager
import kotlinx.android.synthetic.main.activity_product.*

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    private val product: Product
        get() = intent.getSerializableExtra(AppNavigator.PRODUCT) as Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product)

        setupToolbar()
        setImageTransition()

        binding.product = product

        txtOriginalPrice.paintFlags = txtOriginalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

    }

    private fun setImageTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val imageTransitionName = intent.extras.getString(EXTRA_IMAGE_TRANSITION_NAME)
            binding.imgProduct.image.transitionName = imageTransitionName
        }
        binding.imgProduct.image.post {
            val imageUrl = product.photos?.first()?.run {
                MediaManager.get().getUrl(
                    publicId,
                    crop,
                    gravity,
                    binding.imgProduct.image.measuredWidth,
                    binding.imgProduct.image.measuredHeight
                )
            }
            binding.imgProduct.image.loadTransition(this, imageUrl)
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.run {
            setDisplayShowTitleEnabled(false)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.share -> {
                val i = Intent(Intent.ACTION_SEND)
                i.type = "text/plain"
                i.putExtra(Intent.EXTRA_TEXT, product.title)
                startActivity(Intent.createChooser(i, getString(R.string.share_msg)))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
