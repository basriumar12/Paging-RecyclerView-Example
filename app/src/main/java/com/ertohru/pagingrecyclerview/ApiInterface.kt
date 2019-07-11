package id.bukku.bukkuapps.network

import id.bukku.bukkuapps.model.*
import id.bukku.bukkuapps.model.product.all_product.AllProductResponse
import id.bukku.bukkuapps.model.product.all_product.BodyAllProductByCodePublisherResponse
import id.bukku.bukkuapps.model.product.all_product.BodyAllProductResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {


    @POST("partner/getAllBookByPublisher")
    fun getAllProductByCodePublisher(
        @Body body: BodyAllProductByCodePublisherResponse
    ): Call<AllProductResponse>

    @POST("product/getAllProduct")
    fun getAllProduct(
        @Body body: BodyAllProductResponse
    ): Call<AllProductResponse>




}

