package com.sorabh.datastore.ui.fragment

import android.os.Bundle
import android.os.CountDownTimer
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
import com.sorabh.datastore.R
import com.sorabh.datastore.databinding.FragmentSplashBinding
import com.sorabh.datastore.ui.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private val viewModel: SplashViewModel by viewModels()
    private lateinit var navController: NavController
    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        navController = findNavController()
        object : CountDownTimer(5000, 45) {
            override fun onTick(millisUntilFinished: Long) {
                binding.progressLinear.progress++
                binding.txvProgress.text =
                    getString(R.string.count, binding.progressLinear.progress)
            }

            override fun onFinish() {
                lifecycleScope.launch {
                    repeatOnLifecycle(Lifecycle.State.RESUMED) {
                        viewModel.isLoginFlow.collect {
                            if (it)
                                navController.navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
                            else
                                navController.navigate(SplashFragmentDirections.actionSplashFragmentToSignUpFragment())
                        }
                    }
                }
            }

        }.start()

        return binding.root
    }

}