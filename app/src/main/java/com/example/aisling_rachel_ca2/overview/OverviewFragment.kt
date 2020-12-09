package com.example.aisling_rachel_ca2.overview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.aisling_rachel_ca2.R
import com.example.aisling_rachel_ca2.databinding.FragmentOverviewBinding
import com.example.aisling_rachel_ca2.network.ShoppingApiFilter

class OverviewFragment : Fragment() {
    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val binding = FragmentOverviewBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.photosGrid.adapter = PhotoGridAdapter(PhotoGridAdapter.OnClickListener {
            viewModel.displayItemDetails(it)
        })

        viewModel.navigateToSelectedItem.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(OverviewFragmentDirections.actionShowDetail(it))
                viewModel.displayItemDetailsComplete()
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.updateFilter(
            when (item.itemId) {
                R.id.show_vegetable_menu -> ShoppingApiFilter.SHOW_VEGETABLES
                R.id.show_fruit_menu -> ShoppingApiFilter.SHOW_FRUITS
                R.id.show_meat_menu -> ShoppingApiFilter.SHOW_MEATS
                R.id.show_dairy_menu -> ShoppingApiFilter.SHOW_DAIRY
                else -> ShoppingApiFilter.SHOW_ALL
            }
        )
        return true
    }
}