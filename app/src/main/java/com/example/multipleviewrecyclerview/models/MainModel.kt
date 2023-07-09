package com.example.multipleviewrecyclerview.models

import com.example.multipleviewrecyclerview.constant.Constants
typealias ItemID = (Int)

data class MainModel(
    val itemType:ItemID=Constants.IMAGE1,
    val imageModel: List<ImageModel>?=null,
    val bannerModel: BannerModel
)
