package com.example.mona.sportapp

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class MainActivity : Activity() {

    private var sportList: List<Sport>? = null
    private var sportAdapter: SportAdapter? = null
    private var recyclerView: RecyclerView? = null

    private val ROOT_URL = "https://gist.githubusercontent.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder = Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = builder.create<SportApi>(SportApi::class.java!!)
        val call = api.getMyJSON()

        sportList = ArrayList<Sport>()
        call.enqueue(object : Callback<SportList>{
            override fun onResponse(call: Call<SportList>, response: Response<SportList>) {
                if (response.isSuccessful()) {
                    sportList = response.body().sport!!
                    recyclerView = findViewById(R.id.recycleview) as RecyclerView
                    sportAdapter = SportAdapter(this@MainActivity, sportList)
                    val eLayoutManager = LinearLayoutManager(applicationContext)
                    recyclerView!!.setLayoutManager(eLayoutManager)
                    recyclerView!!.setItemAnimator(DefaultItemAnimator())
                    recyclerView!!.setAdapter(sportAdapter)
                }
            }


            override fun onFailure(call: Call<SportList>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity, "Download fail", Toast.LENGTH_LONG).show()
            }
        })
    }
}
