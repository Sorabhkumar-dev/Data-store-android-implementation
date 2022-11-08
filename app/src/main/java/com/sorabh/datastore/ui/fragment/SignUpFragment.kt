package com.sorabh.datastore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sorabh.datastore.R
import com.sorabh.datastore.databinding.FragmentSignupBinding
import com.sorabh.datastore.ui.viewmodel.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpFragment : Fragment() {
    private val viewModel: SignUpViewModel by viewModels()
    private lateinit var binding: FragmentSignupBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupBinding.inflate(layoutInflater)
        navController = findNavController()
        binding.btnSignUp.setOnClickListener {
            lifecycleScope.launch {
                signUp()
            }
        }
        return binding.root
    }

    private suspend fun signUp() {
        val name = binding.edtName.text.toString()
        val email = binding.edtEmail.text.toString()
        val phone = binding.edtPhone.text.toString()
        val userName = binding.edtUserName.text.toString()
        val address = binding.edtAddress.text.toString()
        val password = binding.edtPassword.text.toString()
        val confirmPassword = binding.edtConfirmPassword.text.toString()
        if (name.isNotEmpty() && email.isNotEmpty() && phone.length == 10 && userName.isNotEmpty()
            && address.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()
            && password == confirmPassword
        ) {
            viewModel.writeName(name)
            viewModel.writeEmail(email)
            viewModel.writePhone(phone)
            viewModel.writeUserName(userName)
            viewModel.writeAddress(address)
            viewModel.writePassword(password)
            viewModel.writeIsLogin(true)
            navController.navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())
        } else
            Toast.makeText(
                context,
                getString(R.string.please_fill_all_the_fields),
                Toast.LENGTH_LONG
            ).show()
    }
}