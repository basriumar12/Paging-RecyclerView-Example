package id.bukku.bukkuapps.model.product.all_product

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class AllProductItem (

    @field:SerializedName("code")
    val code: String? = null,

    @field: SerializedName("title")
    val title: String? = null,

    @field: SerializedName("type")
    val type: String? = null,

    @field: SerializedName("category")
    val category: String? = null,

    @field: SerializedName("book_category")
    val book_category: String? = null,

    @field: SerializedName("genre")
    val genre: String? = null,

    @field: SerializedName("current_stock")
    val current_stock: Int? = null,

    @field: SerializedName("normal_price")
    val normalPrice: Int? = null,

    @field: SerializedName("sell_discount")
    val sell_discount: Int? = null,

    @field: SerializedName("sell_price")
    val sellPrice: Int? = null,

    @field: SerializedName("image1")
    val image1: String? = null,

    @field: SerializedName("image2")
    val image2: String? = null,

    @field: SerializedName("image3")
    val image3: String? = null,

    @field: SerializedName("image4")
    val image4: String? = null,

    @field: SerializedName("notes")
    val notes: String? = null,

    @field: SerializedName("penulis_code")
    val penulis_code: String? = null,

    @field: SerializedName("penulis")
    val penulis: String? = null,

    @field: SerializedName("publisher_code")
    val publisher_code: String? = null,

    @field: SerializedName("penerbit")
    val penerbit: String? = null,

    @field: SerializedName("total_qty")
    val total_qty: Int? = null


)