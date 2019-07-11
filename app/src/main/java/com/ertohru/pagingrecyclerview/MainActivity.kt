package com.ertohru.pagingrecyclerview

import android.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import id.bukku.bukkuapps.model.product.all_product.AllProductItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductViewTest {
    override fun showAllProduct(dataAllProduct: List<AllProductItem>) {
        itemAllProduct.addAll(dataAllProduct)
        allProductAdapter.notifyDataSetChanged()
//
    }

    override fun showAllProductAdd(dataAllProduct: List<AllProductItem>) {
        Log.e("Tag","data produk add"+ Gson().toJson(dataAllProduct))
        this.allDataLoaded = true
        if (dataAllProduct.size == 0){
            allDataLoaded = true
        }else {
            itemAllProduct.addAll(dataAllProduct)
            allProductAdapter.notifyDataSetChanged()
            Log.d("RECYCLER_VIEW", "has reached the bottom")
        }


            //rv_browse_product_fragment.adapter = allProductAdapter

    }

    override fun showData(countPage: String, countData: String) {

    }
    private var savedInstanceState: Bundle? = null


    private var itemAllProduct: MutableList<AllProductItem> = mutableListOf()
    private  var allProductAdapter = AllProductAdapterLoadMore (this,itemAllProduct)

    private val data = ArrayList<String>()
    private val peopleAdapter = PeopleAdapter(data)

    private var allDataLoaded = false
    var current = 1

    companion object {
        private var listOfAllProduct: MutableList<AllProductItem> = mutableListOf()
        lateinit var presenter: ProductPresenterTest
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = ProductPresenterTest(this)
        presenter.getAllProduct()
        openFragment(NewProdukFragment())
//
//        setupRecyclerView()
//        Toast.makeText(this@MainActivity, "currentloaded" +current, Toast.LENGTH_SHORT).show()
//
//
//        Log.d("RECYCLER_VIEW", "has reached the current oncreate $current")
//        fillData()



    }

    private fun openFragment(fragment: androidx.fragment.app.Fragment){
        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                .commit()
        }
    }


    private fun setupRecyclerView(){
        recyclerView.layoutManager = GridLayoutManager(this,7)
        recyclerView.adapter = allProductAdapter

        // check if recyclerview scroll reach the bottom
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){

            var directiorDown:Boolean = false

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                directiorDown = dy > 0
            }


            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

                if (recyclerView.canScrollVertically(1).not()
                    && newState == RecyclerView.SCROLL_STATE_IDLE
                    && directiorDown) {
                    current += 1
                    loadMore()
                    Log.d("RECYCLER_VIEW", "has reached the bottom ")
                    Log.d("RECYCLER_VIEW", "has reached the current $current")




                    if(!allDataLoaded) {

                        Toast.makeText(this@MainActivity, "data loaded page" +current, Toast.LENGTH_SHORT).show()

                    }
                    else
                        Toast.makeText(this@MainActivity, "All data loaded" , Toast.LENGTH_SHORT).show()

                }else{

                }

            }

        })
    }

    private fun loadMore() {
        presenter.getAllProductWithParam(1, current)
    }

    private fun fillData(){
        val data = ArrayList<String>()
        data.add("A")
        data.add("B")
        data.add("C")
        data.add("D")
        data.add("E")
        data.add("F")
        data.add("G")
        data.add("H")
        data.add("I")
        data.add("J")
        data.add("K")
        data.add("L")
        data.add("M")
        data.add("N")
        data.add("O")
        data.add("P")
        data.add("Q")


        data.add("A")
        data.add("B")
        data.add("C")
        data.add("D")
        data.add("E")
        data.add("F")
        data.add("G")
        data.add("H")
        data.add("I")
        data.add("J")
        data.add("K")
        data.add("L")
        data.add("M")
        data.add("N")
        data.add("O")
        data.add("P")
        data.add("Q")

        this.data.addAll(data)

        // make adapter check the new data or data has changed
        peopleAdapter.notifyDataSetChanged()
    }

    private fun fillDataNext(){
        val data = ArrayList<String>()
        data.add("R")
        data.add("S")
        data.add("T")
        data.add("U")
        data.add("V")
        data.add("W")
        data.add("X")
        data.add("Y")
        data.add("Z")

        data.add("1")
        data.add("2")
        data.add("3")
        data.add("4")
        data.add("5")
        data.add("W")
        data.add("X")
        data.add("Y")
        data.add("10")

        this.allDataLoaded = true

        this.data.addAll(data)
        peopleAdapter.notifyDataSetChanged()
    }
}
