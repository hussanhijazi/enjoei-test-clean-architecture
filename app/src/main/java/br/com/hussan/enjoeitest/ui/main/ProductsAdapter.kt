package br.com.hussan.enjoeitest.ui.main

import br.com.hussan.enjoeitest.domain.Product

class ProductsAdapter(private val clickListenerShare: (Product) -> Unit) {}
//    RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {
//
//    private var facts: List<Product> = listOf()
//
//    inner class ProductViewHolder(val binding: ListItemProductBinding) : RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//
//        val binding: ListItemProductBinding =
//            DataBindingUtil.inflate(layoutInflater, R.layout.list_item_fact, parent, false)
//        return ProductViewHolder(binding)
//    }
//
//    fun setItems(items: List<Product>) {
//        facts = items
//        notifyDataSetChanged()
//    }
//
//    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
//        val fact = facts[position]
//        holder.binding.fact = fact
//
//        holder.binding.root.setOnClickListener {
//            clickListenerShare.invoke(fact)
//        }
//
//        val cat = fact.category?.let { it } ?: listOf(holder.binding.root.context.getString(R.string.uncategorized))
//
//        holder.binding.lytProductCategory.setData(cat, null)
//    }
//
//    override fun getItemCount() = facts.size
//
//}
