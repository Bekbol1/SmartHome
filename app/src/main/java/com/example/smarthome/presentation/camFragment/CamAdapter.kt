package com.example.smarthome.presentation.camFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.smarthome.databinding.ItemCamBinding
import com.example.smarthome.domain.models.CameraModel

class CamAdapter :
    RecyclerView.Adapter<CamAdapter.CameraViewHolder>() {

    private var list = mutableListOf<CameraModel.Data.Camera>()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(cameras: List<CameraModel.Data.Camera>){
        list.clear()
        list.addAll(cameras)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
        return CameraViewHolder(
            ItemCamBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.toBind(list[position])
    }

    inner class CameraViewHolder(private val binding: ItemCamBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun toBind(camera: CameraModel.Data.Camera) {
            binding.tvNameCamera.text = camera.name
            binding.imgCamera.load(camera.snapshot)
            if (camera.favorites) binding.ivFavorites.visibility = View.VISIBLE
            else binding.ivFavorites.visibility = View.GONE
        }
    }
}