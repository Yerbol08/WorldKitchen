package com.example.worldkitchen.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.worldkitchen.R
import com.example.worldkitchen.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val data = arrayListOf<Food>()
        data.add(Food(R.string.food1, R.drawable.image1, R.string.text1))
        data.add(Food(R.string.food2, R.drawable.image2, R.string.text2))
        data.add(Food(R.string.food3, R.drawable.image3, R.string.text3))
        data.add(Food(R.string.food4, R.drawable.image4, R.string.text4))
        data.add(Food(R.string.food5, R.drawable.image5, R.string.text5))
        val adapter = context?.let { FoodAdapter(data, it) }
        binding.recyclerView.adapter = adapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}