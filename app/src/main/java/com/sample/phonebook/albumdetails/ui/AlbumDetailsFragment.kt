package com.sample.phonebook.albumdetails.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.sample.phonebook.R
import com.sample.phonebook.album.model.AlbumModel
import com.sample.phonebook.album.ui.adapter.AlbumAdapterListener
import com.sample.phonebook.album.viewmodel.AlbumViewModel
import com.sample.phonebook.common.ui.BaseFragment
import com.sample.phonebook.databinding.AlbumDetailsFragmentBinding

class AlbumDetailsFragment : BaseFragment(){

    lateinit var albumVM: AlbumViewModel
    var model: AlbumModel? = null


    companion object {
        var EXTRA_ALBUM_MODEL = "model"
        fun newInstance(model: AlbumModel?): AlbumDetailsFragment {
            val fragment = AlbumDetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(EXTRA_ALBUM_MODEL, model)
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = arguments?.getParcelable<AlbumModel>(EXTRA_ALBUM_MODEL)
        albumVM = ViewModelProviders.of(this).get(AlbumViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val parentView = super.onCreateView(inflater, container, savedInstanceState)
        val binding = DataBindingUtil.inflate<AlbumDetailsFragmentBinding>(
            inflater,
            R.layout.album_details_fragment,
            container,
            false
        )
        binding.model = model
        setContentView(binding.root, albumVM)

        return parentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        albumVM.headerTitle = getString(R.string.album_id) + ' ' + model?.albumId
        albumVM.headerSubTitle(getString(R.string.photo_id) + ' ' + model?.id)
    }
}