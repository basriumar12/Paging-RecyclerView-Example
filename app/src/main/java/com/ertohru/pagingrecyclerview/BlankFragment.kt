package com.ertohru.pagingrecyclerview

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import id.bukku.bukkuapps.model.product.all_product.AllProductItem
import kotlinx.android.synthetic.main.activity_main.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BlankFragment : Fragment(), ProductViewTest {
    override fun showAllProduct(dataAllProduct: List<AllProductItem>) {
        itemAllProduct.addAll(dataAllProduct)
        allProductAdapter?.notifyDataSetChanged()
//
    }

    override fun showAllProductAdd(dataAllProduct: List<AllProductItem>) {
        Log.e("Tag", "data produk add" + Gson().toJson(dataAllProduct))
        this.allDataLoaded = true
        if (dataAllProduct.size == 0) {
            allDataLoaded = true
        } else {
            itemAllProduct.addAll(dataAllProduct)
            allProductAdapter?.notifyDataSetChanged()
            Log.d("RECYCLER_VIEW", "has reached the bottom")
        }


        //rv_browse_product_fragment.adapter = allProductAdapter

    }

    override fun showData(countPage: String, countData: String) {

    }


    private var itemAllProduct: MutableList<AllProductItem> = mutableListOf()
    private var allProductAdapter : AllProductAdapterLoadMore? = null

    private val data = ArrayList<String>()
    private val peopleAdapter = PeopleAdapter(data)

    private var allDataLoaded = false
    lateinit var presenter: ProductPresenterTest
    var current = 1

    companion object {
        private var listOfAllProduct: MutableList<AllProductItem> = mutableListOf()

    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.activity_main, container, false)
        presenter = ProductPresenterTest(this)
        presenter.getAllProduct()
        recyclerView = view.findViewById(R.id.recyclerView)
        Toast.makeText(activity, "data loaded page" + current, Toast.LENGTH_SHORT).show()
        allProductAdapter = AllProductAdapterLoadMore(activity, itemAllProduct)

        setupRecyclerView()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       presenter = ProductPresenterTest(this)
       presenter.getAllProduct()
    }

    private fun setupRecyclerView() {
        recyclerView?.layoutManager = GridLayoutManager(activity, 7)
        recyclerView?.adapter = allProductAdapter

        // check if recyclerview scroll reach the bottom
        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            var directiorDown: Boolean = false

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                directiorDown = dy > 0
            }


            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

                if (recyclerView.canScrollVertically(1).not()
                    && newState == RecyclerView.SCROLL_STATE_IDLE
                    && directiorDown
                ) {
                    current += 1
                    Log.d("RECYCLER_VIEW", "has reached the bottom ")
                    Log.d("RECYCLER_VIEW", "has reached the current $current")
                    loadMore()


                    if (!allDataLoaded) {

                        Toast.makeText(activity, "data loaded page" + current, Toast.LENGTH_SHORT).show()

                    } else
                        Toast.makeText(activity, "All data loaded", Toast.LENGTH_SHORT).show()

                } else {

                }

            }

        })
    }

    private fun loadMore() {
            presenter.getAllProductWithParam(1,current)
    }


    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

}
