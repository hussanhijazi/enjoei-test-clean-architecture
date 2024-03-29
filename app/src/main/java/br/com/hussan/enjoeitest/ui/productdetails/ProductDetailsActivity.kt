package br.com.hussan.enjoeitest.ui.productdetails

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.hussan.enjoeitest.AppNavigator
import br.com.hussan.enjoeitest.R
import br.com.hussan.enjoeitest.data.model.ProductView
import br.com.hussan.enjoeitest.databinding.ActivityProductBinding
import br.com.hussan.enjoeitest.domain.Photo
import kotlinx.android.synthetic.main.activity_product.*

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    private val product: ProductView
        get() = intent.getParcelableExtra(AppNavigator.PRODUCT) as ProductView

    companion object {
        private const val PRODUCT = "PRODUCT"

        fun newIntent(context: Context, product: ProductView): Intent {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra(PRODUCT, product)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product)

        setupToolbar()
        setImages()

        binding.product = product
        txtOriginalPrice.paintFlags = txtOriginalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

    }

    private fun setImages() {
        product.photos?.let {
            if (it.isNotEmpty()) {
                initImageSlider(it)
            }
        }
    }

    private fun initImageSlider(photos: List<Photo>) {
        vpPhotos.adapter = ImagesAdapter(this, photos)
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
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "${product.title} por R$ ${product.price} na Enjoei")
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(sendIntent, resources.getText(R.string.share_msg)))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
