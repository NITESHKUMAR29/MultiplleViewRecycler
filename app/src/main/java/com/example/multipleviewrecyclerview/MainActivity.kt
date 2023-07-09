package com.example.multipleviewrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.multipleviewrecyclerview.adapters.MainAdapter
import com.example.multipleviewrecyclerview.constant.Constants
import com.example.multipleviewrecyclerview.databinding.ActivityMainBinding
import com.example.multipleviewrecyclerview.models.BannerModel
import com.example.multipleviewrecyclerview.models.ImageModel
import com.example.multipleviewrecyclerview.models.MainModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var list: ArrayList<MainModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(binding) {
            val imageList= arrayListOf<ImageModel>()
            imageList.add(ImageModel(R.drawable.rectangle_1445,Constants.IMAGE1))
            imageList.add(ImageModel(R.drawable.rectangle_1445,Constants.IMAGE2))
            imageList.add(ImageModel(R.drawable.rectangle_1445,Constants.IMAGE1))
            list= ArrayList()
            val randomNumber=(1..2).random()

            list.add(
                MainModel(
                    (1..2).random(),
                    imageList,
                    BannerModel(R.drawable.rectangle_1448)
                )
            )

            list.add(
                MainModel(
                    (1..2).random(),
                    imageList,
                    BannerModel(R.drawable.rectangle_1448)
                )
            )
            list.add(
                MainModel(
                    (1..2).random(),
                    imageList,
                    BannerModel(R.drawable.rectangle_1448)
                )
            )
            list.add(
                MainModel(
                    (1..2).random(),
                    imageList,
                    BannerModel(R.drawable.rectangle_1448)
                )
            )
            list.add(
                MainModel(
                    (1..2).random(),
                    imageList,
                    BannerModel(R.drawable.rectangle_1448)
                )
            )
            list.add(
                MainModel(
                    (1..2).random(),
                    imageList,
                    BannerModel(R.drawable.rectangle_1448)
                )
            )
            list.add(
                MainModel(
                    (1..2).random(),
                    imageList,
                    BannerModel(R.drawable.rectangle_1448)
                )
            )
            list.add(
                MainModel(
                    (1..2).random(),
                    imageList,
                    BannerModel(R.drawable.rectangle_1448)
                )
            )
            list.add(
                MainModel(
                    (1..2).random(),
                    imageList,
                    BannerModel(R.drawable.rectangle_1448)
                )
            )
            val adapter = MainAdapter(this@MainActivity, list)
            binding.mainRecycler.adapter=adapter

        }
    }
}