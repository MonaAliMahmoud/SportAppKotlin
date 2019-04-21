package com.example.mona.sportapp

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

public class SportAdapter (context: Context, athletesss: List<Sport>?) : RecyclerView.Adapter<SportAdapter.CustomViewHolder>() {

    var athletesLi: List<Sport>? = athletesss
    var mcontext: Context = context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.sport, parent, false)

        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val ath = athletesLi!![position]
        holder.name.setText(ath.getName())
        holder.breif.setText(ath.getBrief())

        if (ath.getImage() != "") {
            Glide.with(this.mcontext!!)
                .load(ath.getImage())
                .into(holder.imageAth)

        }else {
            holder.imageAth.visibility= View.GONE
        }

        holder?.imageAth.setOnClickListener {

            val intent = Intent(mcontext, DetailsActivity::class.java)
            intent.putExtra("key", holder.breif.text.toString())
            intent.putExtra("imagekey", ath.getImage())
            mcontext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return athletesLi!!.size
    }

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView
        var breif: TextView
        var imageAth: ImageView

        init {
            name = view.findViewById(R.id.name) as TextView
            breif = view.findViewById(R.id.brief) as TextView
            imageAth = view.findViewById(R.id.imageview) as ImageView
        }
    }
}