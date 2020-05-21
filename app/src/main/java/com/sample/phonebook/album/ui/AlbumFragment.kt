package com.sample.phonebook.album.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.phonebook.R
import com.sample.phonebook.album.model.AlbumModel
import com.sample.phonebook.album.ui.adapter.AlbumAdapter
import com.sample.phonebook.album.ui.adapter.AlbumAdapterListener
import com.sample.phonebook.album.viewmodel.AlbumViewModel
import com.sample.phonebook.common.BaseActivity
import com.sample.phonebook.common.ui.BaseFragment
import com.sample.phonebook.databinding.AlbumFragmentBinding
import kotlinx.android.synthetic.main.album_fragment.*

class AlbumFragment : BaseFragment(), AlbumAdapterListener {

    lateinit var albumVM: AlbumViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        albumVM = ViewModelProviders.of(this).get(AlbumViewModel::class.java)
        albumVM.headerTitle = getString(R.string.album_id)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val parentView = super.onCreateView(inflater, container, savedInstanceState)
        val binding = DataBindingUtil.inflate<AlbumFragmentBinding>(
            inflater,
            R.layout.album_fragment,
            container,
            false
        )
        setContentView(binding.root, albumVM)

        return parentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_view.layoutManager = LinearLayoutManager(activity)

        //Fetch user data
        albumVM.fetchAlbumsData()

        //Observe the items
        albumVM.items.observe(this, object : Observer<List<AlbumModel>> {
            override fun onChanged(models: List<AlbumModel>?) {
                activity?.let {
                    var albumId: String =
                        if (models?.isNullOrEmpty() == true) "" else models[0].albumId ?: ""
                    albumVM.headerTitle(getString(R.string.album_id) + ' ' + albumId)
                    recycler_view.adapter = AlbumAdapter(it, models, this@AlbumFragment)
                }
            }

        })

        albumVM.mediatorLiveData.observe(this, object : Observer<List<AlbumModel>> {
            override fun onChanged(t: List<AlbumModel>?) {

            }

        })
    }

    override fun onItemClicked(model: AlbumModel?) {
        activity?.let {
            (it as BaseActivity).navigationController?.launchAlbumDetailScreen(model)
        }
    }
}