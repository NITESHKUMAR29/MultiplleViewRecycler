package com.example.multipleviewrecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.multipleviewrecyclerview.R
import com.example.multipleviewrecyclerview.constant.Constants
import com.example.multipleviewrecyclerview.databinding.ItemImage1Binding
import com.example.multipleviewrecyclerview.databinding.ItemImage2Binding
import com.example.multipleviewrecyclerview.models.ImageModel

class ImageAdapter(private val context: Context, private val listImage: List<ImageModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Constants.IMAGE1 -> {
                ImageViewHolder1(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_image1,
                        parent,
                        false
                    )
                )

            }
            Constants.IMAGE2 -> {
                ImageViewHolder2(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_image2,
                        parent,
                        false
                    )
                )

            }

            else -> {
                ImageViewHolder1(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_image1,
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return listImage.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       when(holder.itemViewType){
           Constants.IMAGE1->{
               val imageViewHolder1: ImageViewHolder1 = holder as ImageViewHolder1
               setImage1(imageViewHolder1.binding,listImage[position])
           }
           Constants.IMAGE2->{
               val imageViewHolder2: ImageViewHolder2 = holder as ImageViewHolder2
               setImage2(imageViewHolder2.binding,listImage[position])
           }
       }
    }

    override fun getItemViewType(position: Int): Int {
        return listImage[position].itemType
    }

    inner class ImageViewHolder1(val binding: ItemImage1Binding) : RecyclerView.ViewHolder(binding.root)
    inner class ImageViewHolder2(val binding: ItemImage2Binding) : RecyclerView.ViewHolder(binding.root)
    private fun setImage1(binding: ItemImage1Binding,imageModel: ImageModel){
        binding.imageView.setImageResource(imageModel.imageResId)
    }
    private fun setImage2(binding: ItemImage2Binding,imageModel: ImageModel){
        binding.imageView.setImageResource(imageModel.imageResId)
    }



}