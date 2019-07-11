package com.ertohru.pagingrecyclerview

import android.util.Log
import com.google.gson.Gson
import id.bukku.bukkuapps.model.product.all_product.AllProductItem
import id.bukku.bukkuapps.model.product.all_product.AllProductResponse
import id.bukku.bukkuapps.model.product.all_product.BodyAllProductResponse
import id.bukku.bukkuapps.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductPresenterTest(private val view: ProductViewTest) {

    private var listOfAllProduct: MutableList<AllProductItem> = mutableListOf()



    fun getAllProduct() {

        val postServices = ApiClient.create()
        postServices.getAllProduct(
            BodyAllProductResponse(
                "",
                "",
                "",
                1000,
                2000000,
                1,
                1,
                10
            )
        ).enqueue(object : Callback<AllProductResponse> {
            override fun onFailure(call: Call<AllProductResponse>, t: Throwable) {
                Log.e("tag", "error ${t.message}")
            }

            override fun onResponse(call: Call<AllProductResponse>, response: Response<AllProductResponse>) {

                response?.let { allProductResponse ->
                    if (allProductResponse.isSuccessful) {
                        val body = allProductResponse.body()
                        body?.let {
                            Log.d("tag", "Response ${body.list} list")

                            body.list?.let { it ->
                                listOfAllProduct.clear()
                                listOfAllProduct.addAll(it)
                            }
                            view.showAllProduct(listOfAllProduct)
                            view.showData(response.body()?.countPage.toString(), response.body()?.countData.toString())
                        }
                    }
                }
            }
        })
    }

    fun getAllProductWithParam(sort : Int, page : Int) {

        val postServices = ApiClient.create()
        postServices.getAllProduct(
            BodyAllProductResponse(
                "",
                "",
                "",
                1000,
                2000000,
                sort,
                page,
                10
            )
        ).enqueue(object : Callback<AllProductResponse> {
            override fun onFailure(call: Call<AllProductResponse>, t: Throwable) {
                Log.e("tag", "error ${t.message}")
            }

            override fun onResponse(call: Call<AllProductResponse>, response: Response<AllProductResponse>) {

                response?.let { allProductResponse ->
                    if (allProductResponse.isSuccessful) {
                        val body = allProductResponse.body()
                        body?.let {


                            body.list?.let { it ->
                                listOfAllProduct.clear()
                                listOfAllProduct.addAll(it)
                            }
                            view.showAllProductAdd(listOfAllProduct)
                            view.showData(response.body()?.countPage.toString(), response.body()?.countData.toString())
                        }
                    }
                }
            }
        })
    }

    fun getAllProductTerbaru() {

        val postServices = ApiClient.create()
        postServices.getAllProduct(
            BodyAllProductResponse(
                "",
                "",
                "",
                1000,
                2000000,
                2,
                1,
                10
            )
        ).enqueue(object : Callback<AllProductResponse> {
            override fun onFailure(call: Call<AllProductResponse>, t: Throwable) {
                Log.e("tag", "error ${t.message}")
            }

            override fun onResponse(call: Call<AllProductResponse>, response: Response<AllProductResponse>) {

                response?.let { allProductResponse ->
                    if (allProductResponse.isSuccessful) {
                        val body = allProductResponse.body()
                        body?.let {
                            Log.d("tag", "Response ${body.list} list")

                            body.list?.let { it ->
                                listOfAllProduct.clear()
                                listOfAllProduct.addAll(it)
                            }
                            view.showAllProduct(listOfAllProduct)
                            view.showData(response.body()?.countPage.toString(), response.body()?.countData.toString())
                        }
                    }
                }
            }
        })
    }

    fun getAllProductTerendah() {

        val postServices = ApiClient.create()
        postServices.getAllProduct(
            BodyAllProductResponse(
                "",
                "",
                "",
                1000,
                2000000,
                4,
                1,
                10
            )
        ).enqueue(object : Callback<AllProductResponse> {
            override fun onFailure(call: Call<AllProductResponse>, t: Throwable) {
                Log.e("tag", "error ${t.message}")
            }

            override fun onResponse(call: Call<AllProductResponse>, response: Response<AllProductResponse>) {

                response?.let { allProductResponse ->
                    if (allProductResponse.isSuccessful) {
                        val body = allProductResponse.body()
                        body?.let {
                            Log.d("tag", "Response ${body.list} list")

                            body.list?.let { it ->
                                listOfAllProduct.clear()
                                listOfAllProduct.addAll(it)
                            }
                            view.showAllProduct(listOfAllProduct)
                            view.showData(response.body()?.countPage.toString(), response.body()?.countData.toString())
                        }
                    }
                }
            }
        })
    }

    fun getAllProductTertinggi() {

        val postServices = ApiClient.create()
        postServices.getAllProduct(
            BodyAllProductResponse(
                "",
                "",
                "",
                1000,
                2000000,
                3,
                1,
                10
            )
        ).enqueue(object : Callback<AllProductResponse> {
            override fun onFailure(call: Call<AllProductResponse>, t: Throwable) {
                Log.e("tag", "error ${t.message}")
            }

            override fun onResponse(call: Call<AllProductResponse>, response: Response<AllProductResponse>) {

                response?.let { allProductResponse ->
                    if (allProductResponse.isSuccessful) {
                        val body = allProductResponse.body()
                        body?.let {
                            Log.d("tag", "Response ${body.list} list")

                            body.list?.let { it ->
                                listOfAllProduct.clear()
                                listOfAllProduct.addAll(it)
                            }
                            view.showAllProduct(listOfAllProduct)
                            view.showData(response.body()?.countPage.toString(), response.body()?.countData.toString())
                        }
                    }
                }
            }
        })
    }
}