package com.juan.petagram2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.juan.petagram2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var pets = ArrayList<Pet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateData()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = PetAdapter(pets)
        var countFavoritePets = 0
        for(pet in pets) {
            if(pet.voteCount > 0) {
                countFavoritePets++
            }
        }
        binding.starsCount.text = countFavoritePets.toString()

        binding.starsBackground.setOnClickListener {
            startActivity(Intent(this, FavoriteActivity::class.java))
        }
        setSupportActionBar(binding.toolbar)
        binding.toolbar.inflateMenu(R.menu.menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun populateData() {
        pets.add(Pet(name = "Catty"
            , image = AppCompatResources.getDrawable(this, R.drawable.ic_baseline_pets_24)!!
            , voteCount = 0))
        pets.add(Pet(name = "Patty"
            , image = AppCompatResources.getDrawable(this, R.drawable.ic_baseline_pets_24)!!
            , voteCount = 2))
        pets.add(Pet(name = "Ratty"
            , image = AppCompatResources.getDrawable(this, R.drawable.ic_baseline_pets_24)!!
            , voteCount = 3))
        pets.add(Pet(name = "Tatty"
            , image = AppCompatResources.getDrawable(this, R.drawable.ic_baseline_pets_24)!!
            , voteCount = 4))
        pets.add(Pet(name = "Matty"
            , image = AppCompatResources.getDrawable(this, R.drawable.ic_baseline_pets_24)!!
            , voteCount = 5))
    }
}