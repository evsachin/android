package com.learngram.androidtuts.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.learngram.androidtuts.models.Hobbie
import com.learngram.androidtuts.R
import com.learngram.androidtuts.showToast

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobbie>) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txvTitle: TextView = itemView.findViewById(R.id.txvTitle)
        private val imgShare: ImageView = itemView.findViewById(R.id.imgShare)
        private var currentHobby: Hobbie? = null

        init {
            itemView.setOnClickListener {
                currentHobby?.let {
                    context.showToast("${it.title} Clicked!")
                }
            }

            imgShare.setOnClickListener {
                currentHobby?.let {
                    val message = "My hobby is: ${it.title}"
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        putExtra(Intent.EXTRA_TEXT, message)
                        type = "text/plain"
                    }
                    context.startActivity(Intent.createChooser(intent, "Please select an app:"))
                }
            }
        }

        fun setData(hobby: Hobbie) {
            txvTitle.text = hobby.title
            this.currentHobby = hobby
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = hobbies.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setData(hobbies[position])
    }
}
