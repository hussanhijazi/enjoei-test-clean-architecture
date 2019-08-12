package br.com.hussan.enjoeitest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.hussan.enjoeitest.R
import br.com.hussan.enjoeitest.data.model.ProductView
import br.com.hussan.enjoeitest.databinding.ListItemProductBinding

class ProductsAdapter(private val clickListenerItem: (ProductView) -> Unit) :
    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    private var products: List<ProductView> = listOf()

    inner class ProductViewHolder(val binding: ListItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: ListItemProductBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item_product, parent, false)
        return ProductViewHolder(binding)
    }

    fun setItems(items: List<ProductView>) {
        products = items
        notifyDataSetChanged()
    }

    fun addItems(items: List<ProductView>) {
        products += items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.binding.product = product

        holder.binding.root.setOnClickListener {
            clickListenerItem.invoke(product)
        }
    }

    override fun getItemCount() = products.size

}
