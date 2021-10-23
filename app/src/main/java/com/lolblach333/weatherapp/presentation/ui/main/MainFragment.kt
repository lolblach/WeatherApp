package com.lolblach333.weatherapp.presentation.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lolblach333.weatherapp.R
import com.lolblach333.weatherapp.databinding.MainFragmentBinding
import com.lolblach333.weatherapp.presentation.ui.main.adapter.CitiesAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()
    private var dataBinding: MainFragmentBinding? = null
    private val adapter = CitiesAdapter { city ->
        dataBinding?.swipeRefresh?.isRefreshing = true

        // TODO check weather for this city
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.getCities(requireContext())

        dataBinding =
            MainFragmentBinding.bind(inflater.inflate(R.layout.main_fragment, container, false))

        return dataBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        observeViewModel()
    }

    private fun initUI() {
        dataBinding?.rvCities?.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.citiesLiveData.observe(viewLifecycleOwner) { cities ->
            adapter.submitList(cities)
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
