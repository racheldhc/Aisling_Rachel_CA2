package com.example.aisling_rachel_ca2.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.aisling_rachel_ca2.databinding.FragmentDetailBinding
import com.example.aisling_rachel_ca2.detail.DetailFragmentArgs
import com.example.aisling_rachel_ca2.detail.DetailViewModel
import com.example.aisling_rachel_ca2.detail.DetailViewModelFactory

class CategoryFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        @Suppress("UNUSED_VARIABLE")
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val shoppingItem = DetailFragmentArgs.fromBundle(arguments!!).selectedProperty

        val viewModelFactory = DetailViewModelFactory(shoppingItem, application)

        binding.viewModel = ViewModelProviders                                                                                                                          .of(
            this, viewModelFactory).get(DetailViewModel::class.java)

        return binding.root
    }
}