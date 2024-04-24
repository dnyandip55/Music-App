package com.example.musicappnew

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context:Activity,val dataList:List<Data>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //create a view in case layout manager fails to create a view

       val itemView=LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //populate the data into view
        val currentData=dataList[position]
        val mediaPlayer=MediaPlayer.create(context,currentData.preview.toUri())

        holder.title.text=currentData.title

        Picasso.get().load(currentData.album.cover).into(holder.image)

        holder.play.setOnClickListener(){
            mediaPlayer.start()
        }
        holder.pause.setOnClickListener{
            mediaPlayer.stop()
        }




    }
    class MyViewHolder(val v:View):RecyclerView.ViewHolder(v) {

        val image:ImageView
        val title:TextView
        val play:ImageButton
        val pause:ImageButton

        init {
            image=v.findViewById(R.id.imageView)
            title=v.findViewById(R.id.musicTitle)
            play=v.findViewById(R.id.play)
            pause=v.findViewById(R.id.pause)
        }




    }
}