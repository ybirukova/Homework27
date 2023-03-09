package com.example.homework27.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.homework27.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<CatViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val imageView = findViewById<ImageView>(R.id.iv_cat)

        viewModel.getListOfBreeds()
        viewModel.getListOfBreedNames()

        viewModel.breedNamesLiveData.observe(this) {
            if (spinner != null) {
                val adapter = ArrayAdapter(
                    this, android.R.layout.simple_spinner_item, it
                )
                spinner.adapter = adapter
            }
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var selectedBreedId = viewModel.breedLiveData.value?.get(position)?.breedId
                if (selectedBreedId != null) {
                    viewModel.getImagesUrl(selectedBreedId)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        viewModel.catLiveData.observe(this) {
            Glide
                .with(this)
                .load(it[0].imageUrl)
                .into(imageView)
        }
    }
}