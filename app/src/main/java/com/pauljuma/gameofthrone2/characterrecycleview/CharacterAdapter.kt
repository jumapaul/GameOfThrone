package com.pauljuma.gameofthrone2.characterrecycleview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pauljuma.gameofthrone2.R
import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterDataItem
import com.pauljuma.gameofthrone2.util.Resource
import kotlinx.android.synthetic.main.character_recycleview.view.*

class CharacterAdapter() : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

   inner class CharacterViewHolder(item:View): RecyclerView.ViewHolder(item)

    private val differCallback = object : DiffUtil.ItemCallback<ThronesCharacterDataItem>(){
        override fun areItemsTheSame(
            oldItem: ThronesCharacterDataItem,
            newItem: ThronesCharacterDataItem
        ): Boolean {
            return oldItem.imageUrl == newItem.imageUrl
        }

        override fun areContentsTheSame(
            oldItem: ThronesCharacterDataItem,
            newItem: ThronesCharacterDataItem
        ): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_recycleview, parent, false)

        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
       val character = differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this).load(character.imageUrl).into(riCharacter)
            tvCharacterName.text = character.firstName
        }
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }

}