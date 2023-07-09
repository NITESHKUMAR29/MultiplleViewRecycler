package com.example.multipleviewrecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.multipleviewrecyclerview.R
import com.example.multipleviewrecyclerview.constant.Constants
import com.example.multipleviewrecyclerview.databinding.ItemBannerBinding
import com.example.multipleviewrecyclerview.databinding.ItemHorizontalRecyclerViewBinding
import com.example.multipleviewrecyclerview.models.BannerModel
import com.example.multipleviewrecyclerview.models.ImageModel
import com.example.multipleviewrecyclerview.models.MainModel

class MainAdapter(private val context: Context, private val list: List<MainModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Constants.RECYCLER -> {
                ImageViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_horizontal_recycler_view,
                        parent,
                        false
                    )
                )
            }

            Constants.BANNER -> {
                BannerViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_banner,
                        parent,
                        false
                    )
                )
            }

            else -> {
                ImageViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_horizontal_recycler_view,
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


            when(holder.itemViewType){
                Constants.RECYCLER->{
                    val imageViewHolder: ImageViewHolder = holder as ImageViewHolder
                    list[position].imageModel?.let { setImageRecycler(imageViewHolder.binding, it) }
                }
                Constants.BANNER->{
                    val bannerViewHolder: BannerViewHolder = holder as BannerViewHolder
                    setBanner(bannerViewHolder.binding,list[position].bannerModel)
                }
            }
    }

    override fun getItemViewType(position: Int): Int {
            return list[position].itemType
    }

    inner class ImageViewHolder(val binding: ItemHorizontalRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class BannerViewHolder(val binding: ItemBannerBinding) :
        RecyclerView.ViewHolder(binding.root)

    private fun setBanner(binding: ItemBannerBinding, bannerModel: BannerModel) {
        binding.bannerImage.setImageResource(bannerModel.imageResId)

    }
    private fun setImageRecycler(binding: ItemHorizontalRecyclerViewBinding, list: List<ImageModel>) {
        val adapter=ImageAdapter(context,list)
        binding.horizontalRecyclerView.adapter=adapter
    }

}