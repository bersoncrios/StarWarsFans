package io.github.bersoncrios.starwarsfans.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.bersoncrios.starwarsfans.databinding.PersonRowBinding

class PersonAdapter(val context: Context, var personsList: io.github.bersoncrios.starwarsfans.models.Persons, val onClickListener: OnClickListener)
    : RecyclerView.Adapter<PersonAdapter.MyViewHolder>() {

    lateinit var binding: PersonRowBinding

    // View Holder
    class MyViewHolder(var binding: PersonRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(person: io.github.bersoncrios.starwarsfans.models.Result){
            binding.person = person
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = PersonRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return  MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val person = personsList.results[position]
        holder.bind(person)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(person)
        }
    }

    class OnClickListener(val clickListener: (person: io.github.bersoncrios.starwarsfans.models.Result) -> Unit) {
        fun onClick(person: io.github.bersoncrios.starwarsfans.models.Result) = clickListener(person)
    }

    override fun getItemCount(): Int = personsList.results.size
}