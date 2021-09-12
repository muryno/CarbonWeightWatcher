package com.carbonWeightwatchers.cww.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carbonWeightwatchers.cww.BuildConfig
import com.carbonWeightwatchers.cww.R
import com.carbonWeightwatchers.cww.data.model.CarbonWeightWatcherModelItem
import com.carbonWeightwatchers.cww.databinding.ListItemBinding
import com.carbonWeightwatchers.cww.presenter.fragment.HomeFragmentDirections
import com.carbonWeightwatchers.cww.presenter.interfaces.OnRecyclerItemClickListener
import javax.inject.Inject


class weightWatcherAdapter @Inject constructor() :
    RecyclerView.Adapter<weightWatcherAdapter.MyViewHolder>() {

    private var listener: OnRecyclerItemClickListener<CarbonWeightWatcherModelItem>? = null

    fun addListener(listener: OnRecyclerItemClickListener<CarbonWeightWatcherModelItem>) {
        this.listener = listener
    }

    private val callback = object : DiffUtil.ItemCallback<CarbonWeightWatcherModelItem>() {
        override fun areItemsTheSame(
            oldItemCarbon: CarbonWeightWatcherModelItem,
            newItemCarbon: CarbonWeightWatcherModelItem
        ): Boolean {
            return oldItemCarbon.title == newItemCarbon.title
        }

        override fun areContentsTheSame(
            oldItemCarbon: CarbonWeightWatcherModelItem,
            newItemCarbon: CarbonWeightWatcherModelItem
        ): Boolean {
            return oldItemCarbon == newItemCarbon
        }

    }

    val differ = AsyncListDiffer(this, callback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val weightWatcherItem = differ.currentList[position]
        holder.bind(weightWatcherItem)
    }


    inner class MyViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(carbonWeightWatcherModelItem: CarbonWeightWatcherModelItem?) {
            binding.title.text = carbonWeightWatcherModelItem?.title
            val posterURL = BuildConfig.BASE_URL + carbonWeightWatcherModelItem?.image
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(binding.imageView)


            binding.cardView.setOnClickListener {
                if (carbonWeightWatcherModelItem != null) {
                    val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(carbonWeightWatcherModelItem)
                    Navigation.findNavController(binding.root).navigate(action)

                   // listener?.onRecyclerItemClickListener(carbonWeightWatcherModelItem)
                }
            }


        }
    }

}