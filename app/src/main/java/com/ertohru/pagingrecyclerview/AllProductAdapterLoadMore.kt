package com.ertohru.pagingrecyclerview

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import id.bukku.bukkuapps.model.product.all_product.AllProductItem
import kotlinx.android.synthetic.main.browse_product_item.view.*

import java.text.NumberFormat
import java.util.*

class AllProductAdapterLoadMore(var context: Context?, var allProduct: List<AllProductItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var localeID = Locale("in", "ID")

    companion object {

        // View Types
        private val ITEM = 0
        private val LOADING = 1
        private val HERO = 2

        private val BASE_URL_IMG = "https://image.tmdb.org/t/p/w200"
    }

    private var isLoadingAdded = false
    private var retryPageLoad = false


    var formatRupiah = NumberFormat.getCurrencyInstance(localeID)
    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = allProduct.get(position)

        if (holder is ViewHolder) {
            loadItem(holder, position)

        } else if (holder is LoadViewHolder) {

        }


    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            HERO
        } else {
            if (position == allProduct!!.size - 1 && isLoadingAdded) LOADING else ITEM
        }
    }




    private fun loadItem(holder: ViewHolder, position: Int) {

        val item = allProduct!![position]
        val data = allProduct.get(position)

        holder.bindItem(allProduct.get(position))


        holder.tvTitle.text = allProduct.get(position).title
        holder.tvAuthor.text = allProduct.get(position).penulis
        holder.tvSellPrice.text = formatRupiah.format(allProduct.get(position).sellPrice).toString()
        holder.tvNormalPrice.text = formatRupiah.format(allProduct.get(position).normalPrice).toString()
        holder.tvNormalPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG


        val options = RequestOptions()
            .fitCenter()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
            .dontAnimate()
            .dontTransform()

        context?.let {
            Glide.with(it).setDefaultRequestOptions(options).load(allProduct.get(position).image1).into(holder.ivImage)
        }


    }

    private fun loadProgress(vieHolder: LoadViewHolder, position: Int) {
        //load progress

    }


    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        if (viewType == VIEW_TYPE_ITEM) {
//
//            var v = LayoutInflater.from(context).inflate(id.bukku.bukkuapps.R.layout.browse_product_item, p0, false)
//            return ViewHolder(v)
//        } else {
//
//            var v = LayoutInflater.from(context).inflate(id.bukku.bukkuapps.R.layout.item_loading, p0, false)
//            return LoadViewHolder(v)
//        }

        var v = LayoutInflater.from(context).inflate(R.layout.browse_product_item, p0, false)
          return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return allProduct.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardProduct = itemView.card_product
        val tvTitle = itemView.tv_all_product_title
        val tvAuthor = itemView.tv_all_product_author
        val ivImage = itemView.iv_all_product
        val tvSellPrice = itemView.tv_allproduct_sellprice
        val tvNormalPrice = itemView.tv_allproduct_normalprice

        fun bindItem(data: AllProductItem) {
            itemView.setOnClickListener {
            //    itemView.context.startActivity<DetailProductActivity>("data" to data)
            }
        }

    }

    class LoadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }


}