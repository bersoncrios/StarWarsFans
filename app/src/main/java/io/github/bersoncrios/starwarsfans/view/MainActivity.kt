package io.github.bersoncrios.starwarsfans.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.shimmer.ShimmerFrameLayout
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
                adapter = PersonAdapter(
                    this, it,
                    PersonAdapter.OnClickListener {person ->
                        Toast.makeText(applicationContext, person.url, Toast.LENGTH_SHORT).show()
                    }
                )

                binding.rvPersons.adapter = adapter
                adapter.notifyDataSetChanged()
                binding.shimmerLayout.startShimmerAnimation()
                binding.shimmerLayout.visibility = View.GONE
                binding.rvPersons.visibility = View.VISIBLE
            }
        }
    }

    override fun onResume() {
        binding.shimmerLayout.startShimmerAnimation()
        super.onResume()
    }

    override fun onPause() {
        binding.shimmerLayout.stopShimmerAnimation()
        super.onPause()
    }
}