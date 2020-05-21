package com.sample.phonebook.common.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.sample.phonebook.R
import com.sample.phonebook.common.viewmodel.BaseViewModel
import com.sample.phonebook.databinding.CommonBaseFragmentBinding

open class BaseFragment : Fragment() {

    private lateinit var baseViewModel: BaseViewModel
    private lateinit var baseBinding: CommonBaseFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        baseBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.common_base_fragment, container, false)
        return baseBinding.root
    }


    /**
     * Method to initialize base view models
     */
    private fun initViewModel(viewModel: BaseViewModel?) {
        if (viewModel != null)
            baseViewModel = viewModel
        else
            baseViewModel = ViewModelProviders.of(this).get(BaseViewModel::class.java)

        baseBinding.baseViewModel = baseViewModel
    }

    /**
     * This method will set the content view to the root layout
     *
     * @param view Content view to be shown.
     */
    protected fun setContentView(
        view: View?, viewModel: BaseViewModel? = null
    ) {
        baseBinding.contentView.addView(view)
        initViewModel(viewModel)
        baseViewModel.showContentView()
    }

    protected fun setBackgroundColor(color: Int) {
        baseBinding.root.setBackgroundColor(color)
    }

    /**
     * This method will handle whether Fragment has focus or not
     */
    open fun onWindowFocusChange(hasFocus: Boolean) {

    }
}