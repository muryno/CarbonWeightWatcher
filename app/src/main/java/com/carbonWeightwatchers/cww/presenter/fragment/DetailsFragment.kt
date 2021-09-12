package com.carbonWeightwatchers.cww.presenter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.carbonWeightwatchers.cww.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    var binding: FragmentDetailsBinding? = null
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@DetailsFragment
            carbonWeightWatcherModelItem =args.weightWatcher
        }
        return binding?.root
    }
}