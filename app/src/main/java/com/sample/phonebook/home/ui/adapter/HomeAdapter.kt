package com.sample.phonebook.home.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.phonebook.home.model.HomeModel
import com.sample.phonebook.databinding.HomeItemViewBinding
import com.sample.phonebook.home.viewmodel.HomeItemViewModel

class HomeAdapter(
    context: Context,
    var items: List<HomeModel>?, private var listener: HomeAdapterListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = HomeItemViewBinding.inflate(inflater, parent, false)

        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.setModel(
                HomeItemViewModel(
                    items?.get(position),
                    object :
                        HomeItemViewModel.HomeItemViewModelListener {
                        override fun onRowClicked(model: HomeModel?) {
                            listener.onItemClicked(model)
                        }

                    })
            )
        }
    }

    class ItemViewHolder(var binding: HomeItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setModel(viewModel: HomeItemViewModel) {
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }
}

interface HomeAdapterListener {
    fun onItemClicked(model: HomeModel?)
}