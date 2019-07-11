package com.ertohru.pagingrecyclerview


import id.bukku.bukkuapps.model.product.all_product.AllProductItem

interface ProductViewTest {

    fun showAllProduct(dataAllProduct: List<AllProductItem>)
    fun showAllProductAdd(dataAllProduct: List<AllProductItem>)
    fun showData(countPage : String, countData : String)
}