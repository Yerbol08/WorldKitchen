package com.example.worldkitchen.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.worldkitchen.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var restorantAdapter: RestorantAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        restorantAdapter = RestorantAdapter()
        binding.recyclerView.adapter = restorantAdapter
        val dashboardViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        dashboardViewModel.item.observe(viewLifecycleOwner){
            restorantAdapter.list = it
            print(it.toString())
        }
        restorantAdapter.onItemClickListener = {
            var intent: Intent = Intent(context, RestorantActivity::class.java)
            intent.putExtra("name", it.name)
            intent.putExtra("image", it.image)
            intent.putExtra("rating", it.rating)
            intent.putExtra("price", it.price)
            startActivity(intent)

        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}