package com.sallyjayz.rickymortyretrofittask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sallyjayz.rickymortyretrofittask.R
import com.sallyjayz.rickymortyretrofittask.api.RickyMortyResult
import com.sallyjayz.rickymortyretrofittask.databinding.ItemViewBinding

class RickMortyAdapter:
    ListAdapter<RickyMortyResult, RickMortyAdapter.RickMortyViewholder>(CharacterComparator()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickMortyViewholder {
        return RickMortyViewholder.create(parent)
    }

    override fun onBindViewHolder(holder: RickMortyViewholder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class RickMortyViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameItemView: TextView = itemView.findViewById(R.id.nameTv)
        private val statusItemView: TextView = itemView.findViewById(R.id.statusTv)
        private val specieItemView: TextView = itemView.findViewById(R.id.specieTv)
        private val imageItemView: ImageView = itemView.findViewById(R.id.imageIv)

        fun bind(result: RickyMortyResult?) {
            nameItemView.text = result?.characterName
            statusItemView.text = result?.characterStatus
            specieItemView.text = result?.characterSpecie
            imageItemView.load(result?.characterImage)
        }

        companion object {
            fun create(parent: ViewGroup): RickMortyViewholder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_view, parent, false)
                return RickMortyViewholder(view)
            }
        }
    }

    class CharacterComparator : DiffUtil.ItemCallback<RickyMortyResult>() {
        override fun areItemsTheSame(oldItem: RickyMortyResult, newItem: RickyMortyResult): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RickyMortyResult, newItem: RickyMortyResult): Boolean {
            return oldItem.id == newItem.id
        }
    }


}



/*
class RickMortyAdapter(private val results: List<RickyMortyResult>): RecyclerView.Adapter<RickMortyAdapter.RickMortyViewholder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickMortyViewholder {
        return RickMortyViewholder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RickMortyViewholder, position: Int) {
        holder.bind(results[position])
    }

    override fun getItemCount(): Int {
        return results.size
    }

    class RickMortyViewholder(private var binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(result: RickyMortyResult) {
            binding.nameTv.text = result.characterName
            binding.statusTv.text = result.characterStatus
            binding.specieTv.text = result.characterSpecie
            binding.imageIv.load(result.characterImage)
        }
    }


}
*/

