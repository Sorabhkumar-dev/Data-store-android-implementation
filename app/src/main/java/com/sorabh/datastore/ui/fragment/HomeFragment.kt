package com.sorabh.datastore.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.sorabh.datastore.databinding.FragmentHomeBinding
import com.sorabh.datastore.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
        setupData()
        return binding.root
    }

    private  fun setupData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                launch {
                viewModel.nameFlow.collect {
                    binding.txvName.text = it
                    Log.d("USER_DATA", it)
                }
                }
                launch {
                    viewModel.emailFlow.collect {
                        binding.txvEmail.text = it
                        Log.d("USER_DATA", it)
                    }
                }
                launch {
                    viewModel.userIdFlow.collect {
                        binding.txvUserId.text = it
                        Log.d("USER_DATA", it)
                    }
                }
                launch {
                    viewModel.addressFlow.collect {
                        binding.txvAddress.text = it
                        Log.d("USER_DATA", it)
                    }
                }
            }
        }
    }
}