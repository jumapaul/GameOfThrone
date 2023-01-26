package com.pauljuma.gameofthrone2.thronesrecycleviews

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.pauljuma.gameofthrone2.R
import com.pauljuma.gameofthrone2.characterapi.data.ThronesCharacterDataItem
import kotlinx.android.synthetic.main.character_recycleview.view.riCharacter
import kotlinx.android.synthetic.main.character_recycleview.view.tvCharacterName

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    private val items: MutableList<ThronesCharacterDataItem> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(data: List<ThronesCharacterDataItem>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(characterDataItem: ThronesCharacterDataItem) {
            Glide.with(itemView.context).load(characterDataItem.imageUrl).into(itemView.riCharacter)
            itemView.tvCharacterName.text = characterDataItem.fullName

            itemView.setOnClickListener { view ->
                val bundle = Bundle()
                bundle.putSerializable("character", characterDataItem)
                view.findNavController().navigate(R.id.action_homeFragment_to_characterDescriptionFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_recycleview, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}