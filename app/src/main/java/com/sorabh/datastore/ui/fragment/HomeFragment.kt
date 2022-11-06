package com.sorabh.datastore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sorabh.datastore.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import com.sorabh.datastore.ui.viewmodel.HomeViewModel

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        lifecycleScope.launch{ setupData() }
        return binding.root
    }

    private suspend fun setupData() {
        viewModel.nameFlow.collect { binding.txvName.text = it }
        viewModel.emailFlow.collect { binding.txvEmail.text = it }
        viewModel.userIdFlow.collect { binding.txvUserId.text = it }
        viewModel.addressFlow.collect { binding.txvAddress.text = it }
    }
}