package com.sample.phonebook.album.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.phonebook.album.model.AlbumModel
import com.sample.phonebook.album.viewmodel.AlbumItemViewModel
import com.sample.phonebook.databinding.AlbumItemViewBinding

class AlbumAdapter(
    context: Context,
    var items: List<AlbumModel>?, private var listener: AlbumAdapterListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = AlbumItemViewBinding.inflate(inflater, parent, false)

        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.setModel(
                AlbumItemViewModel(
                    items?.get(position),
                    object :
                        AlbumItemViewModel.AlbumItemViewModelListener {
                        override fun onRowClicked(model: AlbumModel?) {
                            listener.onItemClicked(model)
                        }

                    })
            )
        }
    }

    class ItemViewHolder(var binding: AlbumItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setModel(viewModel: AlbumItemViewModel) {
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }
}

interface AlbumAdapterListener {
    fun onItemClicked(model: AlbumModel?)
}