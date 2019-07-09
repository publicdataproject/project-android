package com.song2.publicdata_project

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.song2.publicdata_project.Data.CategoryData
import com.song2.publicdata_project.Data.ShopProductData
import com.song2.publicdata_project.adapter.CategoryRecyclerviewAdapter
import com.song2.publicdata_project.adapter.ProductListRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_shop_intro.*


class ShopIntroActivity : AppCompatActivity() {

    lateinit var producuctRecyclerviewAdapter: ProductListRecyclerViewAdapter
    lateinit var categoryRecyclerviewAdapter: CategoryRecyclerviewAdapter

    lateinit var shopProductDataList: ArrayList<ShopProductData>
    lateinit var categoryDataList : ArrayList<CategoryData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_intro)

        attachRecyclerView()
    }

    fun attachRecyclerView(){
        categoryDataList = ArrayList()
        categoryDataList.add(CategoryData(null,"과일"))
        categoryDataList.add(CategoryData(null,"육류"))
        categoryDataList.add(CategoryData(null,"생활"))
        categoryDataList.add(CategoryData(null,"과일"))
        categoryDataList.add(CategoryData(null,"과일"))

        categoryRecyclerviewAdapter = CategoryRecyclerviewAdapter(this,categoryDataList)
        rv_shop_frag_category_list.adapter = categoryRecyclerviewAdapter
        rv_shop_frag_category_list.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)


        shopProductDataList= ArrayList()
        shopProductDataList.add(ShopProductData(null,"사과","10,000",0))
        shopProductDataList.add(ShopProductData(null,"포도","10,000",0))
        shopProductDataList.add(ShopProductData(null,"배","10,000",0))
        shopProductDataList.add(ShopProductData(null,"감자","10,000",0))
        shopProductDataList.add(ShopProductData(null,"당근","10,000",0))
        shopProductDataList.add(ShopProductData(null,"수박","10,000",0))
        shopProductDataList.add(ShopProductData(null,"참외","10,000",0))

        producuctRecyclerviewAdapter = ProductListRecyclerViewAdapter(this, shopProductDataList)
        rv_shop_frag_sale_product.adapter = producuctRecyclerviewAdapter
        rv_shop_frag_sale_product.layoutManager = GridLayoutManager(this, 2)

    }
}
