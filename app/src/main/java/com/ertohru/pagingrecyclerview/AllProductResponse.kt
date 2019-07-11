package id.bukku.bukkuapps.model.product.all_product

import com.google.gson.annotations.SerializedName

data class AllProductResponse(

    @field:SerializedName("countData")
    val countData: Int? = null,

    @field:SerializedName("list")
    val list: List<AllProductItem>?,

    @field:SerializedName("countPage")
    val countPage: Int? = null
)