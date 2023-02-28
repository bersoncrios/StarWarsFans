package io.github.bersoncrios.starwarsfans.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.bersoncrios.starwarsfans.R
import io.github.bersoncrios.starwarsfans.databinding.ActivityMainBinding
import io.github.bersoncrios.starwarsfans.view.adapter.PersonAdapter
import io.github.bersoncrios.starwarsfans.viewmodels.PersonViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : PersonViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.rvPersons.setHasFixedSize(true)
        binding.rvPersons.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[PersonViewModel::class.java]

        viewModel.fetchPersons()

        viewModel.items.observe(this) { person ->
            person?.let {
                Log.d("TAG", "onCreate: ${it.results}")
                adapter = PersonAdapter(
                    this, it,
                    PersonAdapter.OnClickListener {person ->
                        Toast.makeText(applicationContext, person.name, Toast.LENGTH_SHORT).show()
                    }
                )

                binding.rvPersons.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }
    }
}