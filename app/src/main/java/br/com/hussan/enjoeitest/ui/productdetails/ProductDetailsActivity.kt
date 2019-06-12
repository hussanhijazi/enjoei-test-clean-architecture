package br.com.hussan.enjoeitest.ui.productdetails

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.hussan.enjoeitest.AppNavigator
import br.com.hussan.enjoeitest.R
import br.com.hussan.enjoeitest.databinding.ActivityProductBinding
import br.com.hussan.enjoeitest.domain.Photo
import br.com.hussan.enjoeitest.domain.Product
import kotlinx.android.synthetic.main.activity_product.*

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    private val product: Product
        get() = intent.getSerializableExtra(AppNavigator.PRODUCT) as Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product)

        setupToolbar()
//        setImageTransition()
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
