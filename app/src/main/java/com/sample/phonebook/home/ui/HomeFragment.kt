package com.sample.phonebook.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.phonebook.R
import com.sample.phonebook.common.BaseActivity
import com.sample.phonebook.common.ui.BaseFragment
import com.sample.phonebook.databinding.HomeFragmentBinding
import com.sample.phonebook.home.model.HomeModel
import com.sample.phonebook.home.ui.adapter.HomeAdapter
import com.sample.phonebook.home.ui.adapter.HomeAdapterListener
import com.sample.phonebook.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : BaseFragment(), HomeAdapterListener {

    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.headerTitle = getString(R.string.user_info)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val parentView = super.onCreateView(inflater, container, savedInstanceState)
        val binding = DataBindingUtil.inflate<HomeFragmentBinding>(
            inflater,
            R.layout.home_fragment,
            container,
            false
        )
        //binding.viewModel = homeViewModel
        setContentView(binding.root, homeViewModel)

        return parentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_view.layoutManager = LinearLayoutManager(activity)

        //Fetch user data
        homeViewModel.fetchUsersData()

        //Observe the items
        homeViewModel.items.observe(this, object : Observer<List<HomeModel>> {
            override fun onChanged(models: List<HomeModel>?) {
                activity?.let {
                    recycler_view.adapter = HomeAdapter(it, models, this@HomeFragment)
                }
            }

        })

        homeViewModel.mediatorLiveData.observe(this, object : Observer<List<HomeModel>> {
            override fun onChanged(t: List<HomeModel>?) {

            }

        })
    }

    override fun onItemClicked(model: HomeModel?) {
        activity?.let {
            (it as BaseActivity).navigationController?.launchAlbumsScreen()
        }
    }
}