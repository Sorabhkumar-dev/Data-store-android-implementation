package com.sorabh.datastore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sorabh.datastore.databinding.FragmentHomeBinding
import com.sorabh.datastore.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initializer(inflater)
        setOnClickListener()
        setupData()
        return binding.root
    }

    private fun initializer(inflater: LayoutInflater) {
        binding = FragmentHomeBinding.inflate(inflater)
        navController = findNavController()
    }

    private fun setOnClickListener() {
        binding.btnWallet.setOnClickListener {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToAccountFragment())
        }
        binding.btnPay.setOnClickListener {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToSendMoneyFragment())
        }
    }

    private fun setupData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                launch {
                    viewModel.nameFlow.collect {
                        binding.txvName.text = it
                    }
                }
                launch {
                    viewModel.emailFlow.collect {
                        binding.txvEmail.text = it
                    }
                }
                launch {
                    viewModel.userIdFlow.collect {
                        binding.txvUserId.text = it
                    }
                }
                launch {
                    viewModel.addressFlow.collect {
                        binding.txvAddress.text = it
                    }
                }
            }
        }
    }
}