package com.example.smarthome.presentation.doorsFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.smarthome.databinding.ItemDoorBinding
import com.example.smarthome.domain.models.DoorModel

class DoorAdapter :
    RecyclerView.Adapter<DoorAdapter.DoorViewHolder>() {

    private var list = mutableListOf<DoorModel.Data>()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(doors: List<DoorModel.Data>) {
        list.clear()
        list.addAll(doors)
        notifyDataSetChanged()
    }
    fun doFavoriteItem(adapterPosition: Int) {
        val item = list.removeAt(adapterPosition)
        list.add(0, item)
        notifyItemMoved(adapterPosition, 0)
    }

    fun deleteItem(adapterPosition: Int) {
        list.removeAt(adapterPosition)
        notifyItemRemoved(adapterPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorViewHolder {
        return DoorViewHolder(
            ItemDoorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: DoorViewHolder, position: Int) {
        holder.toBind(list[position])
    }

    inner class DoorViewHolder(private val binding: ItemDoorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun toBind(door: DoorModel.Data) {
            binding.tvNameDoor.text = door.name
            binding.imgDoor.load(door.snapshot)
            binding.tvIsOnline.text = "В сети"
            itemView.setOnClickListener {
                if (binding.imgDoor.visibility == View.GONE && binding.btnPlay.visibility == View.GONE) {
                    showDetails()
                } else {
                    hideDetails()
                }

            }
        }

        private fun hideDetails() {
            binding.imgDoor.visibility = View.GONE
            binding.btnPlay.visibility = View.GONE
        }

        private fun showDetails() {
            binding.imgDoor.visibility = View.VISIBLE
            binding.btnPlay.visibility = View.VISIBLE
        }
    }
}