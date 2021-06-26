package com.juan.petagram2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.juan.petagram2.databinding.PetItemBinding

class PetAdapter(private val petList: ArrayList<Pet>) :
    RecyclerView.Adapter<PetAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val inflate = PetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(petList[position])

    override fun getItemCount() = petList.size

    inner class ViewHolder(private val binding: PetItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pet: Pet) {
            binding.image.setImageDrawable(pet.image)
            binding.name.text = pet.name
            binding.voteCount.text = pet.voteCount.toString()
            if(pet.voteCount > 0) {
                binding.petIcon.visibility = View.VISIBLE
            } else {
                binding.petIcon.visibility = View.GONE
            }
            binding.petVote.setOnClickListener {
                Toast.makeText(context, "Añadiste un voto a ${pet.name}", Toast.LENGTH_SHORT).show()
                pet.voteCount++
                notifyItemChanged(petList.indexOf(pet))
            }
        }
    }
}