package com.sorabh.datastore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sorabh.datastore.databinding.FragmentSignInBinding
import com.sorabh.datastore.ui.viewmodel.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignInFragment : Fragment() {
    private val viewModel: SignInViewModel by viewModels()
    private lateinit var binding: FragmentSignInBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(layoutInflater)
        navController = findNavController()
        binding.btnLogin.setOnClickListener {
            lifecycleScope.launch {
                signIn()
            }
        }
        return binding.root
    }

    private suspend fun signIn() {
            val email = binding.txvEmail.text.toString()
            val phone = binding.txvPhone.text.toString()
            val password = binding.txvPassword.text.toString()
            if (email == viewModel.emailFlow.last() || phone == viewModel.phoneFlow.last() && password == viewModel.passwordFlow.last()) {
                navController.navigate(SignInFragmentDirections.actionSignInFragmentToHomeFragment())
            }
    }
}