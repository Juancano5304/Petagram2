package com.juan.petagram2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.juan.petagram2.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private var pets = ArrayList<Pet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateData()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = PetAdapter(pets)

        setSupportActionBar(binding.toolbar)
        binding.toolbar.inflateMenu(R.menu.menu)

        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
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