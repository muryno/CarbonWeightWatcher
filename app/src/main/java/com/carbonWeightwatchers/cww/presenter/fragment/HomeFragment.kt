package com.carbonWeightwatchers.cww.presenter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.carbonWeightwatchers.cww.databinding.FragmentHomeBinding
import com.carbonWeightwatchers.cww.presenter.viewModel.CarbonWeightWatcherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.empty_box.view.*

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val carbonWeightWatcherViewModel by viewModels<CarbonWeightWatcherViewModel>()
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            viewModel = carbonWeightWatcherViewModel
            lifecycleOwner = this@HomeFragment
        }
        carbonWeightWatcherViewModel.onCreate()
        return binding.root
    }
}